package org.example.Employee.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class ExpertsNotFoundException extends BusinessException {
    public ExpertsNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
