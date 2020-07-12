package com.mohamed.spring.brwry.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice // tells spring mvc this is an exception handler
public class MvcExceptionHandler {

        @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> exceptionHandling(ConstraintViolationException e) {
        List<String> exceptions = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(
                violation ->{
                    exceptions.add(e.getConstraintViolations() + ":" + e.getMessage());
                }
        );

        return new ResponseEntity<>(exceptions , HttpStatus.BAD_REQUEST);
    }

    /*
        Thrown when there is a bind exception between objects
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> handleBindException(BindException e){
            return new ResponseEntity(e.getCause() , HttpStatus.BAD_REQUEST);
    }
}
