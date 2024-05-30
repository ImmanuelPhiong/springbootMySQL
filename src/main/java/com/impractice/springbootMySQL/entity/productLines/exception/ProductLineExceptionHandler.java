package com.impractice.springbootMySQL.entity.productLines.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductLineExceptionHandler {
    @ExceptionHandler(value = {ProductLineNotFoundException.class})
    public ResponseEntity<Object> handleProductLineNotFoundException(
            ProductLineNotFoundException productLineNotFoundException){
        ProductLineException productLineException = new ProductLineException(
                productLineNotFoundException.getMessage(),
                productLineNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(productLineException, HttpStatus.NOT_FOUND);
    }
}
