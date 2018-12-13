package com.cb6.project.userregisterservice.exception;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cb6.project.userregisterservice.user.UserAlreadyExistsException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
		
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserAlreadyExistsException ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
		
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);		
	}
	

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid (MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
			ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
		
			return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);	
	}
}
