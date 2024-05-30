package com.impractice.springbootMySQL.entity.payments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PaymentExceptionHandler {
    @ExceptionHandler(value = {PaymentNotFoundException.class})
    public ResponseEntity<Object> handleCPaymentNotFoundException
            (PaymentNotFoundException paymentNotFoundException){
        PaymentException paymentException = new PaymentException(
                paymentNotFoundException.getMessage(),
                paymentNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(paymentException, HttpStatus.NOT_FOUND);
    }
}
