package com.example.carrest.exception;

public class EntityNotDeletedException extends RuntimeException{
    public EntityNotDeletedException(String message, Throwable cause) {
        super(message, cause);
    }
}
