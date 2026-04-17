package org.example.Favourites.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class FavouritesFoundExceptions extends BusinessException {
    public FavouritesFoundExceptions(String message,String name) {
        super(message,HttpStatus.CONFLICT,name);

    }
}
