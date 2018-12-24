package com.cb6.project.userregisterservice.user;

public class UserAlreadyExistsException extends RuntimeException {
	private String message;
	
	public UserAlreadyExistsException (String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
