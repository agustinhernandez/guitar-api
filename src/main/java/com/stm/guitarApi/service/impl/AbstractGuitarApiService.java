package com.stm.guitarApi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.stm.guitarApi.exception.ServiceGuitarApiException;
import com.stm.guitarApi.request.AbstractGuitarApiRequest;

public class AbstractGuitarApiService {
	
	@Autowired Validator validator;
	

	protected void validate(AbstractGuitarApiRequest command) {
		BindingResult errors = new BeanPropertyBindingResult(command, command.getClass().getName());
		validator.validate(command, errors);
		if (errors.hasErrors()) {
			throw new ServiceGuitarApiException("Request has errors");
		}
	}

}