package com.stm.guitarApi.dao;

import java.util.List;

import com.stm.guitarApi.model.Manufacturer;

public interface ManufacturerDao {

	public List<Manufacturer> list();

	public boolean exists(String manufacturerId);

	public Manufacturer get(String manufacturerId);

	public void save(Manufacturer manufacturer);
	
}
