package org.example.Exceptions;

import org.springframework.http.HttpStatus;

public class InventoryNotFoundException extends BusinessException {
    private HttpStatus status;
    public InventoryNotFoundException(String message, HttpStatus status) {
        super(message,status);
    }
}
