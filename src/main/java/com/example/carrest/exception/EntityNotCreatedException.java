package com.example.carrest.exception;

public class EntityNotCreatedException extends RuntimeException {
    public EntityNotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
