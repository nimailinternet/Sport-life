package org.example.Exceptions;

import org.springframework.http.HttpStatus;

public class ExerciseNotFoundException extends BusinessException {
    private HttpStatus status;
    public ExerciseNotFoundException(String message,HttpStatus status) {
        super(message,status);
    }
}
