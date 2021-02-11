package com.ensa.entities;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class ExceptionResponse {

    private String message;
    private HttpStatus httpStatus;
    private Timestamp timestamp;

    public ExceptionResponse(String message, HttpStatus httpStatus, Timestamp timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
}
