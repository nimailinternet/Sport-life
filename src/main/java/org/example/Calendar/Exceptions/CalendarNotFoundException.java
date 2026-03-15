package org.example.Calendar.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CalendarNotFoundException extends BusinessException {
    public CalendarNotFoundException(String message) {
        super(message,HttpStatus.NOT_FOUND);
    }
}
