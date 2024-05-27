package com.impractice.springbootMySQL.entity.offices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OfficeExceptionHandler {
    @ExceptionHandler(value = {OfficeNotFoundException.class})
    public ResponseEntity<Object> handleOfficeNotFoundException
            (OfficeNotFoundException officeNotFoundException){
        OfficeException officeException = new OfficeException(
                officeNotFoundException.getMessage(),
                officeNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(officeException, HttpStatus.NOT_FOUND);
    }
}
