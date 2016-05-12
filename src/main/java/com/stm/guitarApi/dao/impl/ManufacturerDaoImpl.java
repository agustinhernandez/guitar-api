package com.stm.guitarApi.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stm.guitarApi.dao.GuitarDao;
import com.stm.guitarApi.dao.ManufacturerDao;
import com.stm.guitarApi.model.Manufacturer;

@Component
public class ManufacturerDaoImpl implements ManufacturerDao {
	
	@Autowired
	private GuitarDao guitarDao;

	@Override
	public List<Manufacturer> list() {
		return guitarDao.list().stream().map(guitar -> guitar.getManufacturer()).collect(Collectors.toList());
	}

}
