package com.impractice.springbootMySQL.entity.productLines.exception;

public class ProductLineNotFoundException extends RuntimeException{
    public ProductLineNotFoundException(String message) {
        super(message);
    }

    public ProductLineNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
