package org.example.Exceptions;

import org.springframework.http.HttpStatus;

public class CalendarFoundException extends BusinessException {
    private HttpStatus status;
    public CalendarFoundException(String message,HttpStatus status) {
        super(message,status);
    }
}
