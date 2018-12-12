package com.cb6.project.userloginservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserWrongPasswordException extends RuntimeException {
	public UserWrongPasswordException (String message) {
		super(message);
	}
}
