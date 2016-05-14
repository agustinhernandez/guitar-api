package com.stm.guitarApi.service;

import java.util.List;

import com.stm.guitarApi.dto.ManufacturerDto;
import com.stm.guitarApi.request.ManufacturerRequest;

public interface ManufacturerService {

	public List<ManufacturerDto> list();

	public void create(ManufacturerRequest command);

	public void edit(ManufacturerRequest command, String id);
	
	public ManufacturerDto get(String id);
	
}
