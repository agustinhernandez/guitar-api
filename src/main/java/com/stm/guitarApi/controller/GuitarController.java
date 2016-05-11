package com.stm.guitarApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stm.guitarApi.dto.GuitarDto;
import com.stm.guitarApi.service.GuitarService;

@Controller
public class GuitarController {
	
	@Autowired
	private GuitarService guitarService;

	
	@RequestMapping(value = "/guitar",
	  method = RequestMethod.GET,
	  headers = "Accept=application/json")
	@ResponseBody
	public List<GuitarDto> list() {
		return guitarService.list();
	}

}
