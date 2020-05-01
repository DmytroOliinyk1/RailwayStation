package com.epam.exception;

public class NotDeleteException extends RuntimeException {
    public NotDeleteException(String message) {
        super(message);
    }
}
