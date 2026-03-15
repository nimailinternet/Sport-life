package org.example.Avatar.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class AvatarNotFoundException extends BusinessException {
    public AvatarNotFoundException(String message) {
        super(message,HttpStatus.NOT_FOUND);
    }
}
