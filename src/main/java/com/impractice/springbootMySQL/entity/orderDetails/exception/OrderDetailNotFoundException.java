package com.impractice.springbootMySQL.entity.orderDetails.exception;

public class OrderDetailNotFoundException extends RuntimeException{
    public OrderDetailNotFoundException(String message) {
        super(message);
    }

    public OrderDetailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
