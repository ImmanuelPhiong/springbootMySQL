package com.impractice.springbootMySQL.entity.offices.exception;

public class OfficeNotFoundException extends RuntimeException{
    public OfficeNotFoundException(String message){
        super(message);
    }
    public OfficeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
