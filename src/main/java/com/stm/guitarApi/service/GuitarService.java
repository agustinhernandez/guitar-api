package com.stm.guitarApi.service;

import java.util.List;

import com.stm.guitarApi.dto.GuitarDto;

public interface GuitarService {

	public List<GuitarDto> list(Integer page, Integer count);

	public int getLastPage(int count);

	public List<GuitarDto> listOrderByYear(Integer page, Integer count);
	
}
