package org.example.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedEmployee extends BusinessException {
    private HttpStatus status;
    public UnauthorizedEmployee(String message, HttpStatus status) {
        super(message,status);
    }
}
