package com.dbs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InvalidCustomerIdException extends RuntimeException {
	public InvalidCustomerIdException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InvalidCustomerIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
//	public InvalidCustomerIdException(String message, Throwable cause) {
//		super(message, cause);
//		// TODO Auto-generated constructor stub
//	}
	
	
}
