package org.example.Exceptions;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;

public class FavouritesFound extends BusinessException {
    private HttpStatus status;
    public FavouritesFound(String message, HttpStatus status) {
        super(message,status);
    }
}
