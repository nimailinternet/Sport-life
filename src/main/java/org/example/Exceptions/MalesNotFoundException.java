package org.example.Exceptions;

import org.springframework.http.HttpStatus;

public class MalesNotFoundException extends BusinessException {
    private HttpStatus status;
    public MalesNotFoundException(String message, HttpStatus status) {
        super(message,status);
    }
}
