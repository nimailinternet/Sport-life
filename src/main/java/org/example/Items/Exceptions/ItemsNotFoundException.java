package org.example.Items.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class ItemsNotFoundException extends BusinessException {
    public ItemsNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);

    }
}
