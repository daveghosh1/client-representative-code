package com.springboot.exception;

public final class InvalidHeaderFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public InvalidHeaderFieldException(String message) {
		this.setMessage(message);
	}

    @Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}