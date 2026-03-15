package org.example.Males.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class MalesNotFoundException extends BusinessException {
    public MalesNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);

    }
}
