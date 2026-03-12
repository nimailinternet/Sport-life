package org.example.Exceptions;

import org.springframework.http.HttpStatus;

public class FavouritesNotFoundException extends BusinessException {
    private HttpStatus status;
    public FavouritesNotFoundException(String message,HttpStatus status) {
        super(message,status);
    }
}
