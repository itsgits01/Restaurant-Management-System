package org.example.restomanagement.RestoManagement;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Mark the exception with a response status (optional)
@ResponseStatus(HttpStatus.NOT_FOUND) // This will return a 404 status code
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message); // Call the superclass constructor with the message
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause); // Call the superclass constructor with the message and cause
    }
}
