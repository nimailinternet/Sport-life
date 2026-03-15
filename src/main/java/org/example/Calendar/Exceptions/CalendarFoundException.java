package org.example.Calendar.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CalendarFoundException extends BusinessException {
    public CalendarFoundException(String message) {
        super(message,HttpStatus.CONFLICT);

    }
}
