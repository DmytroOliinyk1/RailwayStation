package com.epam.exception;

public class NotSaveException extends RuntimeException {
    public NotSaveException(String message) {
        super(message);
    }
}
