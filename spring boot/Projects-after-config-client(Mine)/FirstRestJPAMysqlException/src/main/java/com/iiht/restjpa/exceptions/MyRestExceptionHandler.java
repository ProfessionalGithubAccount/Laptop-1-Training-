package com.iiht.restjpa.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyRestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {NullPointerException.class})//For every execption we need to create a specific handler
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	protected ResponseEntity<Object> errorHandler(NullPointerException e , WebRequest req){
		MyErrorResponse error=new MyErrorResponse();
		error.setMessage(e.getMessage());
		error.setErrorCode("406");
		error.setTime(new java.util.Date());
		
		return handleExceptionInternal( e,error,new HttpHeaders(),HttpStatus.NOT_ACCEPTABLE,req);
	}
	
	
	@ExceptionHandler(value= {InValidValueException.class})//For every execption we need to create a specific handler
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	protected ResponseEntity<Object> errorHandler(InValidValueException e , WebRequest req){
		MyErrorResponse error=new MyErrorResponse();
		error.setMessage(e.getMessage());
		error.setErrorCode("404");
		error.setTime(new java.util.Date());
		
		return handleExceptionInternal( e,error,new HttpHeaders(),HttpStatus.NOT_ACCEPTABLE,req);
	}
	
	
	//THis one is for the general exception..the default ..if no exceptionis handled by handled it will handle this
	@ExceptionHandler(value= {Exception.class})//For every execption we need to create a specific handler
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	protected ResponseEntity<Object> errorHandler(Exception e , WebRequest req){
		MyErrorResponse error=new MyErrorResponse();
		error.setMessage(e.getMessage());
		error.setErrorCode("406");
		error.setTime(new java.util.Date());
		
		return handleExceptionInternal( e,error,new HttpHeaders(),HttpStatus.NOT_ACCEPTABLE,req);
	}
}
