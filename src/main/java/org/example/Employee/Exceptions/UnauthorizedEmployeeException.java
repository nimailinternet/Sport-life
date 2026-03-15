package org.example.Employee.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UnauthorizedEmployeeException extends BusinessException {
    public UnauthorizedEmployeeException(String message) {
        super(message,HttpStatus.UNAUTHORIZED);
    }
}
