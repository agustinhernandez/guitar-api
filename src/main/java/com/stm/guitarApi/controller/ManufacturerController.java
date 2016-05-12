package com.stm.guitarApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stm.guitarApi.dto.ManufacturerDto;
import com.stm.guitarApi.service.ManufacturerService;

@Controller
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService manufacturerService;

	
	@RequestMapping(value = "/manufacturer",
	  method = RequestMethod.GET,
	  headers = "Accept=application/json")
	@ResponseBody
	public List<ManufacturerDto> list() {
		return manufacturerService.list();
	}

}
