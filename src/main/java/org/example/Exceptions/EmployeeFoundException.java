package org.example.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmployeeFoundException extends BusinessException {
    private HttpStatus status;
    public EmployeeFoundException(String message, HttpStatus status) {
        super(message,status);
    }
}
