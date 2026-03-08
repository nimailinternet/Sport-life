package org.example.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmployeeFound extends BusinessException {
    private HttpStatus status;
    public EmployeeFound(String message,HttpStatus status) {
        super(message,status);
    }
}
