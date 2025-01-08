package com.springboot.exception;

public class InvalidHeaderFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public InvalidHeaderFieldException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}