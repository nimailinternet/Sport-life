package org.example.Favourites.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class FavouritesNotFoundException extends BusinessException {
    public FavouritesNotFoundException(String message) {
        super(message,HttpStatus.NOT_FOUND);

    }
}
