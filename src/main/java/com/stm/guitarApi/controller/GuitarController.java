package com.stm.guitarApi.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stm.guitarApi.dto.GuitarDto;
import com.stm.guitarApi.request.GuitarRequest;
import com.stm.guitarApi.service.GuitarService;
import com.stm.guitarApi.utils.BindingResultUtils;

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
	
	@RequestMapping(value = "/guitar/filterByManufacturer/{manufacturerId}",
	  method = RequestMethod.GET,
	  headers = "Accept=application/json")
	@ResponseBody
	public List<GuitarDto> listFilterByManufacturer(@PathVariable String manufacturerId,
			@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer count) {
		return guitarService.listFilterByManufacturer(manufacturerId, page, count);
	}
	
	@RequestMapping(value = "/guitar",
	  method = RequestMethod.POST,
	  headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> create(@Valid @RequestBody GuitarRequest command,
			BindingResult bindingResult, HttpServletResponse response) {

		if (bindingResult.hasErrors()) {
			return BindingResultUtils.handleBindingResultErrors(response, bindingResult);
		}

		guitarService.create(command);
		return Collections.singletonMap("successMessage", "Guitar created successfully.");
	}
	
	@RequestMapping(value = "/guitar/{id}",
	  method = RequestMethod.PUT,
	  headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> edit(@Valid @RequestBody GuitarRequest command, @PathVariable String id,
			BindingResult bindingResult, HttpServletResponse response) {

		if (bindingResult.hasErrors()) {
			return BindingResultUtils.handleBindingResultErrors(response, bindingResult);
		}

		guitarService.edit(command, id);
		return Collections.singletonMap("successMessage", "Guitar edited successfully.");
	}
	
	@RequestMapping(value = "/guitar/{id}",
	  method = RequestMethod.GET,
	  headers = "Accept=application/json")
	@ResponseBody
	public GuitarDto get(@PathVariable String id) {
		return guitarService.get(id);
	}

}
