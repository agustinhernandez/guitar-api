package com.stm.guitarApi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stm.guitarApi.dao.ManufacturerDao;
import com.stm.guitarApi.dto.ManufacturerDto;
import com.stm.guitarApi.model.Manufacturer;
import com.stm.guitarApi.request.ManufacturerRequest;
import com.stm.guitarApi.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl extends AbstractGuitarApiService implements ManufacturerService {
	
	@Autowired
	private ManufacturerDao manufacturerDao;

	@Override
	public List<ManufacturerDto> list() {
		return manufacturerDao.list().stream()
				.sorted((manufacturer1, manufacturer2) -> manufacturer1.getName().compareTo(manufacturer2.getName()))
				.map(this::newInstance).collect(Collectors.toList());
	}
	
	private ManufacturerDto newInstance(Manufacturer manufacturer) {
		return ManufacturerDto.newInstance(
				manufacturer.getId(),
				manufacturer.getName(),
				manufacturer.getFormerlyCalled(),
				manufacturer.getFoundedYear(),
				manufacturer.getFoundedPlace(),
				manufacturer.getFounder(),
				manufacturer.getHeadquarters(),
				manufacturer.getAreaServed(),
				manufacturer.getWebsite(),
				manufacturer.getLogoBase64());
	}

	@Override
	@Transactional
	public void create(ManufacturerRequest command) {
		validate(command);
		manufacturerDao.save(newInstance(command));
	}
	
	private Manufacturer newInstance(ManufacturerRequest command) {
		return Manufacturer.newInstance(
				command.getName(),
				command.getFormerlyCalled(),
				(command.getFoundedYear() != null) ? command.getFoundedYear() : 0,
				command.getFoundedPlace(),
				command.getFounder(),
				command.getHeadquarters(),
				command.getAreaServed(),
				command.getWebsite(),
				command.getLogoBase64());
	}

}
