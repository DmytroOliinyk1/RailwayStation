package com.epam.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotDeleteExceptionTest {
    @Test
    public void NotDeleteExceptionMessageTest() {
        try {
            throw new NotDeleteException("exception message");
        } catch (NotDeleteException e) {
            assertEquals("exception message", e.getMessage());
        }
    }
}
