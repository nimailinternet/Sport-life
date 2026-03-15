package org.example.Employee.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmployeeFoundException extends BusinessException {
    public EmployeeFoundException(String message) {
        super(message,HttpStatus.CONFLICT);
    }
}
