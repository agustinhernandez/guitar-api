package com.stm.guitarApi.exception;

public class ServiceGuitarApiException extends RuntimeException {

	  private static final long serialVersionUID = 1L;

	  public ServiceGuitarApiException() {
	    super();
	  }

	  public ServiceGuitarApiException(String message, Throwable cause) {
	    super(message, cause);
	  }

	  public ServiceGuitarApiException(String message) {
	    super(message);
	  }

}
