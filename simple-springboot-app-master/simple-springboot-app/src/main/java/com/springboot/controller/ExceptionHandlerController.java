package com.springboot.controller;

import com.springboot.exception.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
class ExceptionHandlerController {

    @ExceptionHandler(InvalidFieldException.class)
    public String handleInvalidFieldException(InvalidFieldException ex) {
        return ex.getMessage();
    }
}