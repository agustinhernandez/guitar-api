package com.stm.guitarApi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stm.guitarApi.dao.GuitarDao;
import com.stm.guitarApi.dao.ManufacturerDao;
import com.stm.guitarApi.dto.GuitarDto;
import com.stm.guitarApi.exception.ServiceGuitarApiException;
import com.stm.guitarApi.model.Classification;
import com.stm.guitarApi.model.Guitar;
import com.stm.guitarApi.request.GuitarRequest;
import com.stm.guitarApi.service.GuitarService;
import com.stm.guitarApi.utils.PaginatedListUtils;

@Service
public class GuitarServiceImpl extends AbstractGuitarApiService implements GuitarService {
	
	@Autowired
	private GuitarDao guitarDao;
	
	@Autowired 
	private ManufacturerDao manufacturerDao;
	

	@Override
	public List<GuitarDto> list(Integer page, Integer count) {
		List<GuitarDto> guitars = guitarDao.list().stream()
				.sorted((guitar1, guitar2) -> guitar1.getModel().compareTo(guitar2.getModel()))
				.map(this::newInstance).collect(Collectors.toList());
		return list(page, count, guitars);
	}

	@SuppressWarnings("unchecked")
	private List<GuitarDto> list(Integer page, Integer count, List<GuitarDto> guitars) {
		if (!PaginatedListUtils.isPaginationRequired(page, count)) {
			return guitars;
		}
		
		return PaginatedListUtils.getPaginatedList(guitars, page, count);
	}

	private GuitarDto newInstance(Guitar guitar) {
		return GuitarDto.newInstance(
				guitar.getId(),
				guitar.getModel(),
				(guitar.getYear() != 0) ? guitar.getYear() : null,
				guitar.getClassification(),
				guitar.getManufacturer().getId(),
				guitar.getBodyType(),
				guitar.getNeckJoint(),
				guitar.getScaleMm(),
				guitar.getBodyWood(),
				guitar.getNeckWood(),
				guitar.getFretboardWood(),
				guitar.getBridge(),
				guitar.getPickup(),
				guitar.getImageBase64());
	}

	@Override
	public int getLastPage(int count) {
		int sizeList = guitarDao.count();
		return PaginatedListUtils.getLastPage(sizeList, count);
	}

	@Override
	public List<GuitarDto> listOrderByYear(Integer page, Integer count) {
		List<GuitarDto> guitars = guitarDao.list().stream()
				.sorted((guitar1, guitar2) -> new Integer(guitar1.getYear()).compareTo(guitar2.getYear()))
				.map(this::newInstance).collect(Collectors.toList());
		return list(page, count, guitars);
	}
	
	@Override
	public List<GuitarDto> listFilterByManufacturer(String manufacturerId, Integer page, Integer count) {
		validateManufacturerId(manufacturerId);
		
		List<GuitarDto> guitars = guitarDao.list().stream()
				.filter(guitar -> guitar.getManufacturer().getId().equals(manufacturerId))
				.map(this::newInstance).collect(Collectors.toList());
		return list(page, count, guitars);
	}
	
	@Override
	public GuitarDto get(String id) {
		validateGuitarId(id);
		return newInstance(guitarDao.get(id));
	}

	private void validateGuitarId(String id) {
		if (!guitarDao.exists(id)) {
			throw new ServiceGuitarApiException("Guitar ID not exists");
		}
	}

	@Override
	@Transactional
	public void create(GuitarRequest command) {
		validate(command);
		guitarDao.save(newInstance(command));
	}
	
	@Override
	@Transactional
	public void edit(GuitarRequest command, String id) {
		validateGuitarId(id);
		validate(command);
		Guitar guitar = newInstance(command);
		guitar.setId(id);
		guitarDao.update(guitar);
	}
	
	@Override
	@Transactional
	public void delete(String id) {
		validateGuitarId(id);
		guitarDao.delete(id);
	}
	
	private Guitar newInstance(GuitarRequest command) {
		String manufacturerId = command.getManufacturerId();
		validateManufacturerId(manufacturerId);
		
		return Guitar.newInstance(
				command.getModel(),
				command.getYear(),
				Classification.valueOf(command.getClassification()),
				manufacturerDao.get(manufacturerId),
				command.getBodyType(),
				command.getNeckJoint(),
				command.getScaleMm(),
				command.getBodyWood(),
				command.getNeckWood(),
				command.getFretboardWood(),
				command.getBridge(),
				command.getPickup(),
				command.getImageBase64());
	}

	private void validateManufacturerId(String id) {
		if (!manufacturerDao.exists(id)) {
			throw new ServiceGuitarApiException("Manufacturer ID not exists");
		}
	}

}
