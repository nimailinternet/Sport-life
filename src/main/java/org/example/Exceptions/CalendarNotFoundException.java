package org.example.Exceptions;

import org.springframework.http.HttpStatus;

public class CalendarNotFoundException extends BusinessException {
    private HttpStatus status;
    public CalendarNotFoundException(String message,HttpStatus status) {
        super(message,status);
    }
}
