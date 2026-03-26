package org.example.Muscle.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class MuscleNotFoundException extends BusinessException {
    public MuscleNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);

    }
}
