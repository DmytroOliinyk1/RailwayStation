package com.epam.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncorrectDataExceptionTest {
    @Test
    public void IncorrectDataExceptionMessageTest() {
        try {
            throw new IncorrectDataException("exception message");
        } catch (IncorrectDataException e) {
            assertEquals("exception message", e.getMessage());
        }
    }
}
