package org.example.Exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BusinessException extends RuntimeException {
    private final HttpStatus status;
    private final String name;
    public BusinessException(String message, HttpStatus status, String name) {
        super(message);
        this.status=status;
        this.name = name;
    }
}
