package com.dbs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InvalidBankException extends RuntimeException {
	public InvalidBankException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InvalidBankException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public InvalidBankException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
