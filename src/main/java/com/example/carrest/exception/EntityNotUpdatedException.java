package com.example.carrest.exception;

public class EntityNotUpdatedException extends RuntimeException{
    public EntityNotUpdatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
