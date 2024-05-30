package com.impractice.springbootMySQL.entity.orderDetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderDetailExceptionHandler {
    @ExceptionHandler(value = {OrderDetailNotFoundException.class})
    public ResponseEntity<Object> handleOrderDetailNotFoundException(
            OrderDetailNotFoundException orderDetailNotFoundException) {
        OrderDetailException orderDetailException = new OrderDetailException(
                orderDetailNotFoundException.getMessage(),
                orderDetailNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(orderDetailException, HttpStatus.NOT_FOUND);
    }
}
