package com.epam.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotUpdateExceptionTest {
        @Test
        public void NotUpdateExceptionMessageTest() {
            try {
                throw new NotUpdateException("exception message");
            } catch (NotUpdateException e) {
                assertEquals("exception message", e.getMessage());
            }
        }
}
