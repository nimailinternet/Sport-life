package org.example.Exercise.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class ExerciseNotFoundException extends BusinessException {
    public ExerciseNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);

    }
}
