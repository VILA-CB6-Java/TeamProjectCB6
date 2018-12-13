package com.cb6.project.useractionsservice.exception;

public class ExceptionResponse {
	
	//message
	private String message;
	
	public ExceptionResponse() {}
	
	public ExceptionResponse(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
