package com.stm.guitarApi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stm.guitarApi.dao.ManufacturerDao;
import com.stm.guitarApi.dto.ManufacturerDto;
import com.stm.guitarApi.model.Manufacturer;
import com.stm.guitarApi.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	
	@Autowired
	private ManufacturerDao manufacturerDao;

	@Override
	public List<ManufacturerDto> list() {
		return manufacturerDao.list().stream().map(this::newInstance).collect(Collectors.toList());
	}
	
	private ManufacturerDto newInstance(Manufacturer manufacturer) {
		return ManufacturerDto.newInstance(
				manufacturer.getId(),
				manufacturer.getName(),
				manufacturer.getFormerlyCalled(),
				(manufacturer.getFoundedYear() != 0) ? manufacturer.getFoundedYear() : null,
				manufacturer.getFoundedPlace(),
				manufacturer.getFounder(),
				manufacturer.getHeadquarters(),
				manufacturer.getAreaServed(),
				manufacturer.getWebsite(),
				manufacturer.getLogoBase64());
	}

}
