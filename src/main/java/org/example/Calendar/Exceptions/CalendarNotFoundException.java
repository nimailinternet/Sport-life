package org.example.Calendar.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class CalendarNotFoundException extends BusinessException {
    public CalendarNotFoundException(String message,String name) {
        super(message,HttpStatus.NOT_FOUND,name);
    }
}
