package org.example.Agonists.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class AgonistsNotFoundException extends BusinessException {
    public AgonistsNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);

    }
}
