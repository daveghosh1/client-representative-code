package com.springboot.exception;

public class InvalidHeaderFieldException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidHeaderFieldException(String message) {
        super(message);
    }
}