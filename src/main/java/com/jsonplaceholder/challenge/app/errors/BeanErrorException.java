package com.jsonplaceholder.challenge.app.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BeanErrorException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BeanErrorException(String message) {
		super(message);
	}
}
