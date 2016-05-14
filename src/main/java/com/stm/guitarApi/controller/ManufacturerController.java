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
import org.springframework.web.bind.annotation.ResponseBody;

import com.stm.guitarApi.dto.ManufacturerDto;
import com.stm.guitarApi.request.ManufacturerRequest;
import com.stm.guitarApi.service.ManufacturerService;
import com.stm.guitarApi.utils.BindingResultUtils;

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
	
	@RequestMapping(value = "/manufacturer",
	  method = RequestMethod.POST,
	  headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> create(@Valid @RequestBody ManufacturerRequest command,
			BindingResult bindingResult, HttpServletResponse response) {

		if (bindingResult.hasErrors()) {
			return BindingResultUtils.handleBindingResultErrors(response, bindingResult);
		}

		manufacturerService.create(command);
		return Collections.singletonMap("successMessage", "Manufacturer created successfully.");
	}
	
	@RequestMapping(value = "/manufacturer/{id}",
	  method = RequestMethod.PUT,
	  headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> edit(@Valid @RequestBody ManufacturerRequest command, @PathVariable String id,
			BindingResult bindingResult, HttpServletResponse response) {

		if (bindingResult.hasErrors()) {
			return BindingResultUtils.handleBindingResultErrors(response, bindingResult);
		}

		manufacturerService.edit(command, id);
		return Collections.singletonMap("successMessage", "Manufacturer edited successfully.");
	}
	
	@RequestMapping(value = "/manufacturer/{id}",
	  method = RequestMethod.GET,
	  headers = "Accept=application/json")
	@ResponseBody
	public ManufacturerDto get(@PathVariable String id) {
		return manufacturerService.get(id);
	}

}
