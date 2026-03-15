package org.example.Employee.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmployeeNotFoundException extends BusinessException {
    public EmployeeNotFoundException(String message) {
        super(message,HttpStatus.NOT_FOUND);
    }
}
