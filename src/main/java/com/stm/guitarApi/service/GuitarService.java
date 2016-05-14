package com.stm.guitarApi.service;

import java.util.List;

import com.stm.guitarApi.dto.GuitarDto;
import com.stm.guitarApi.request.GuitarRequest;

public interface GuitarService {

	public List<GuitarDto> list(Integer page, Integer count);

	public int getLastPage(int count);

	public List<GuitarDto> listOrderByYear(Integer page, Integer count);

	public void create(GuitarRequest command);

	public void edit(GuitarRequest command, String id);

	public GuitarDto get(String id);

	public List<GuitarDto> listFilterByManufacturer(String manufacturerId, Integer page, Integer count);
	
}
