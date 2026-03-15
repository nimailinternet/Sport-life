package org.example.Male.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class MaleNotFoundException extends BusinessException {
    public MaleNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);

    }
}
