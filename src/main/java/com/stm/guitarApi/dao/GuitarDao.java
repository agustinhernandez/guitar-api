package com.stm.guitarApi.dao;

import java.util.List;

import com.stm.guitarApi.model.Guitar;

public interface GuitarDao {

	public List<Guitar> list();
	
	public int count();

	public void save(Guitar guitar);

	public boolean exists(String guitarId);

	public Guitar get(String guitarId);

	public void update(Guitar guitar);
	
}
