package org.example.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends BusinessException{
    private HttpStatus status;
    public EmployeeNotFoundException(String message, HttpStatus status) {
        super(message,status);
    }
}
