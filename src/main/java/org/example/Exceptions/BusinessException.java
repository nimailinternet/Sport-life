package org.example.Exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class BusinessException extends RuntimeException {
    private HttpStatus status;
    public BusinessException(String message, HttpStatus status) {
        super(message);
        this.status=status;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
