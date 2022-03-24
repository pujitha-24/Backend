package com.dbs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InvalidPasswordException extends Exception {
	public InvalidPasswordException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InvalidPasswordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public InvalidPasswordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	

}
