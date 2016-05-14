package com.stm.guitarApi.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.stm.guitarApi.dao.GuitarDao;
import com.stm.guitarApi.model.Guitar;

@Component
public class GuitarDaoImpl implements GuitarDao {
	
	@Resource(name="guitarsMap")
	private Map<String, Guitar> guitars;
	

	@Override
	public List<Guitar> list() {
		return new ArrayList<Guitar>(guitars.values());
	}

	@Override
	public int count() {
		return guitars.size();
	}
	
	@Override
	public boolean exists(String guitarId) {
		return guitars.containsKey(guitarId);
	}

	@Override
	public Guitar get(String guitarId) {
		return guitars.get(guitarId);
	}
	
	@Override
	public void save(Guitar guitar) {
		String guitarId = UUID.randomUUID().toString();
		guitar.setId(guitarId);
		guitars.put(guitarId, guitar);
	}
	
	@Override
	public void update(Guitar guitar) {
		guitars.put(guitar.getId(), guitar);
	}

}
