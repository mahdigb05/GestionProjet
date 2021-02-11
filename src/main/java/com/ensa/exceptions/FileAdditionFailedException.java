package com.ensa.exceptions;

public class FileAdditionFailedException extends RuntimeException{

    public FileAdditionFailedException(String message) {
        super(message);
    }
}
