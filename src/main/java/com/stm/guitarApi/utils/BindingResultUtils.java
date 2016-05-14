package com.stm.guitarApi.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class BindingResultUtils {
	
	public static Map<String, Object> handleBindingResultErrors(HttpServletResponse response,
			BindingResult bindingResult) {

		Map<String, Object> model = new HashMap<String, Object>();
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		int count = 1;
		for (ObjectError error : bindingResult.getAllErrors()) {
			FieldError field = (FieldError) error;
			model.put("errorMessage" + count, field.getField() + ": " + error.getDefaultMessage());
			count++;
		}

		return model;
	}
	
}