package org.example.Favourites.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class FavouritesFoundExceptions extends BusinessException {
    public FavouritesFoundExceptions(String message) {
        super(message,HttpStatus.CONFLICT);

    }
}
