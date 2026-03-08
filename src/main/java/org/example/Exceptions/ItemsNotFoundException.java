package org.example.Exceptions;

import org.springframework.http.HttpStatus;

public class ItemsNotFoundException extends BusinessException {
    private HttpStatus status;
    public ItemsNotFoundException(String message, HttpStatus status) {
        super(message,status);
    }
}
