package com.epam.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotFoundExceptionTest {

    @Test
    public void NotFoundExceptionMessageTest() {
        try {
            throw new NotFoundException("exception message");
        } catch (NotFoundException e) {
            assertEquals("exception message", e.getMessage());
        }
    }
}
