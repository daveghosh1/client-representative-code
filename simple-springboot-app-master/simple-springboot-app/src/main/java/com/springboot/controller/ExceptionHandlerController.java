package com.springboot.controller;

import com.springboot.exception.*;
import org.springframework.web.bind.annotation.*;


/**
 * Global exception handler for the application.
 */
@RestControllerAdvice
class ExceptionHandlerController {

    /**
     * Handles InvalidFieldException.
     *
     * @param ex InvalidFieldException
     * @return error message
     */
    @ExceptionHandler(InvalidFieldException.class)
    public String handleInvalidFieldException(InvalidFieldException ex) {
        return ex.getMessage();
    }
}