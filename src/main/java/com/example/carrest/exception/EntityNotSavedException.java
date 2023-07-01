package com.example.carrest.exception;

public class EntityNotSavedException extends RuntimeException {
    public EntityNotSavedException(String message, Throwable cause) {
        super(message, cause);
    }
}
