package com.stm.guitarApi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.stm.guitarApi.exception.ServiceGuitarApiException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	private final String ERROR_CODE_KEY = "errorCode";
	private final String ERROR_MESSAGE_KEY = "errorMessage";
	private final String API_EXCEPTION_ERROR_CODE = "ServiceGuitarApiException";
	private final String UNKNOWN_ERROR_CODE = "Exception";
	private final String UNKNOWN_ERROR_MESSAGE = "Unknown error";

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = ServiceGuitarApiException.class)
	@ResponseBody
	public Map<String, Object> handleException(ServiceGuitarApiException e) {
		return instanceErrorModel(API_EXCEPTION_ERROR_CODE, e.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Map<String, Object> handleException(Exception e) {
		return instanceErrorModel(UNKNOWN_ERROR_CODE, UNKNOWN_ERROR_MESSAGE);
	}

	private Map<String, Object> instanceErrorModel(String errorCode, String errorMessage) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(ERROR_CODE_KEY, errorCode);
		model.put(ERROR_MESSAGE_KEY, errorMessage);
		return model;
	}

}
