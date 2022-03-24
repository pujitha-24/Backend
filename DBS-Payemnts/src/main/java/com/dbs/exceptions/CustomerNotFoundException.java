package com.dbs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {
	public CustomerNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
