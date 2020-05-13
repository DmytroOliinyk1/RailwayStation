package com.epam.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotSaveExceptionTest {
    @Test
    public void NotSaveExceptionMessageTest() {
        try {
            throw new NotSaveException("exception message");
        } catch (NotSaveException e) {
            assertEquals("exception message", e.getMessage());
        }
    }
}
