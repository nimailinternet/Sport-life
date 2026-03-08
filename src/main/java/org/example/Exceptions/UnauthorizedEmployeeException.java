package org.example.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedEmployeeException extends BusinessException {
    private HttpStatus status;
    public UnauthorizedEmployeeException(String message, HttpStatus status) {
        super(message,status);
    }
}
