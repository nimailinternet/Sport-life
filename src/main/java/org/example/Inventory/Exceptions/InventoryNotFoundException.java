package org.example.Inventory.Exceptions;

import org.example.Exceptions.BusinessException;
import org.springframework.http.HttpStatus;

public class InventoryNotFoundException extends BusinessException {
    public InventoryNotFoundException(String message,String name) {
        super(message, HttpStatus.NOT_FOUND,name);

    }
}
