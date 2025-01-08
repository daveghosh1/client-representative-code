package com.springboot.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class InvalidFieldExceptionTest {

    @Test
    public void testInvalidFieldExceptionMessage() {
        String errorMessage = "Invalid field value";
        InvalidFieldException exception = new InvalidFieldException(errorMessage);

        assertNotNull(exception);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void testSetMessage() {
        String initialMessage = "Initial message";
        String updatedMessage = "Updated message";
        InvalidFieldException exception = new InvalidFieldException(initialMessage);

        exception.setMessage(updatedMessage);
        assertEquals(updatedMessage, exception.getMessage());
    }
}