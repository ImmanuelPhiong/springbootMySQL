package com.impractice.springbootMySQL.entity.offices.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class OfficeException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
