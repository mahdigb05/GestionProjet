package com.ensa.exceptionsHandlers;


import com.ensa.entities.ExceptionResponse;
import com.ensa.exceptions.FileAdditionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;

@ControllerAdvice
public class UserExceptionsHandler {

    @ExceptionHandler(value={FileAdditionFailedException.class})
    public ResponseEntity<?> fileAdditionFailedHandler(FileAdditionFailedException e){
        ExceptionResponse response = new ExceptionResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
