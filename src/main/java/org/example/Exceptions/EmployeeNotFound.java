package org.example.Exceptions;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFound extends BusinessException{
    private HttpStatus status;
    public EmployeeNotFound(String message, HttpStatus status) {
        super(message,status);
    }
}
