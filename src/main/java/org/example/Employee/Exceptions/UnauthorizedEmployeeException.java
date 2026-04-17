package org.example.Employee.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class UnauthorizedEmployeeException extends BusinessException {
    public UnauthorizedEmployeeException(String message,String name) {
        super(message,HttpStatus.UNAUTHORIZED,name);
    }
}
