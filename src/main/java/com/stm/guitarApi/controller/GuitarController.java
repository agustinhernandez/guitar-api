package com.stm.guitarApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<GuitarDto> list(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer count) {
		return guitarService.list(page, count);
	}
	
	@RequestMapping(value = "/guitar/lastPage/{count}",
	  method = RequestMethod.GET,
	  headers = "Accept=application/json")
	@ResponseBody
	public int lastPage(@PathVariable int count) {
		return guitarService.getLastPage(count);
	}
	
	@RequestMapping(value = "/guitar/orderByYear",
	  method = RequestMethod.GET,
	  headers = "Accept=application/json")
	@ResponseBody
	public List<GuitarDto> listOrderByYear(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer count) {
		return guitarService.listOrderByYear(page, count);
	}

}
