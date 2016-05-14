package com.stm.guitarApi.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.stm.guitarApi.dao.ManufacturerDao;
import com.stm.guitarApi.model.Manufacturer;

@Component
public class ManufacturerDaoImpl implements ManufacturerDao {
	
	@Resource(name="manufacturersMap")
	private Map<String, Manufacturer> manufacturers;

	@Override
	public List<Manufacturer> list() {
		return new ArrayList<Manufacturer>(manufacturers.values());
	}

	@Override
	public boolean exists(String manufacturerId) {
		return manufacturers.containsKey(manufacturerId);
	}

	@Override
	public Manufacturer get(String manufacturerId) {
		return manufacturers.get(manufacturerId);
	}
	
	@Override
	public void save(Manufacturer manufacturer) {
		String manufacturerId = UUID.randomUUID().toString();
		manufacturer.setId(manufacturerId);
		manufacturers.put(manufacturerId, manufacturer);
	}

	@Override
	public void update(Manufacturer manufacturer) {
		manufacturers.put(manufacturer.getId(), manufacturer);
	}

}
