package com.cb6.project.userregisterservice.exception;

import java.util.Date;


public class ExceptionResponse {
	//timestamp
//	private String timestamp;
	
	//message
	private String message;
	
	//details
//	private String details;
	
	public ExceptionResponse() {}
	
	public ExceptionResponse(String message) {
		this.message=message;
	}

//	public String getTimestamp() {
//		return timestamp;
//	}

//	public void setTimestamp(String timestamp) {
//		this.timestamp = timestamp;
//	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	public String getDetails() {
//		return details;
//	}
//
//	public void setDetails(String details) {
//		this.details = details;
//	}
	
	
}
