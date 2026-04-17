package org.example.Employee.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class EmployeeFoundException extends BusinessException {
    public EmployeeFoundException(String message,String name) {
        super(message,HttpStatus.CONFLICT,name);
    }
}
