package com.dbs.exceptions;


//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(InvalidCustomerIdException.class)
	public ResponseEntity<ErrorResponse> InvalidCustomerIdException(InvalidCustomerIdException invalidcustomer) {
		HttpStatus status=HttpStatus.NOT_FOUND;
		System.out.println(status);
		String message= invalidcustomer.getMessage();
		ErrorResponse error=new ErrorResponse(status,message);
		return new ResponseEntity<ErrorResponse>(error,status);
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> CustomerNotFoundException(CustomerNotFoundException customernotfound) {
		HttpStatus status=HttpStatus.NOT_FOUND;
		System.out.println(status);
		String message= customernotfound.getMessage();
		ErrorResponse error=new ErrorResponse(status,message);
		return new ResponseEntity<ErrorResponse>(error,status);
	}
	@ExceptionHandler(InvalidBankException.class)
	public ResponseEntity<ErrorResponse> InvalidBankException(InvalidBankException invalidbank) {
		HttpStatus status=HttpStatus.NOT_FOUND;
		System.out.println(status);
		String message= invalidbank.getMessage();
		ErrorResponse error=new ErrorResponse(status,message);
		return new ResponseEntity<ErrorResponse>(error,status);
	}
	@ExceptionHandler(InvalidBICException.class)
	public ResponseEntity<ErrorResponse> InvalidBICException(InvalidBICException invalidbic) {
		HttpStatus status=HttpStatus.NOT_FOUND;
		System.out.println(status);
		String message= invalidbic.getMessage();
		ErrorResponse error=new ErrorResponse(status,message);
		return new ResponseEntity<ErrorResponse>(error,status);
	}
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ErrorResponse> InvalidPasswordException(InvalidPasswordException invalidpassword) {
		HttpStatus status=HttpStatus.NOT_FOUND;
		System.out.println(status);
		String message= invalidpassword.getMessage();
		ErrorResponse error=new ErrorResponse(status,message);
		return new ResponseEntity<ErrorResponse>(error,status);
	}
	@ExceptionHandler(InvalidAcHolderException.class)
	public ResponseEntity<ErrorResponse> InvalidAcHolderException(InvalidAcHolderException invalidacholder) {
		HttpStatus status=HttpStatus.NOT_FOUND;
		System.out.println(status);
		String message= invalidacholder.getMessage();
		ErrorResponse error=new ErrorResponse(status,message);
		return new ResponseEntity<ErrorResponse>(error,status);
	}

}
