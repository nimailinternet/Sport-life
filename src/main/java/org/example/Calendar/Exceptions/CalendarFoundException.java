package org.example.Calendar.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class CalendarFoundException extends BusinessException {
    public CalendarFoundException(String message,String name) {
        super(message,HttpStatus.CONFLICT,name);

    }
}
