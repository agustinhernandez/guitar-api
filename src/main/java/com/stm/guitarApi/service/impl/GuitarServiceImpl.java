package com.stm.guitarApi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stm.guitarApi.dao.GuitarDao;
import com.stm.guitarApi.dto.GuitarDto;
import com.stm.guitarApi.model.Guitar;
import com.stm.guitarApi.service.GuitarService;
import com.stm.guitarApi.utils.PaginatedListUtils;

@Service
public class GuitarServiceImpl implements GuitarService {
	
	@Autowired
	private GuitarDao guitarDao;

	@Override
	@SuppressWarnings("unchecked")
	public List<GuitarDto> list(Integer page, Integer count) {
		List<GuitarDto> guitars = guitarDao.list().stream().map(this::newInstance).collect(Collectors.toList());
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

}