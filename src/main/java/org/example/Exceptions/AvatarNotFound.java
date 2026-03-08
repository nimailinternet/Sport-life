package org.example.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AvatarNotFound extends BusinessException {
    private HttpStatus status;
    public AvatarNotFound(String message,HttpStatus status) {
        super(message,status);
    }
}
