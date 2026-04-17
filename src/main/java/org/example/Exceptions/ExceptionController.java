package org.example.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> BusinessError(BusinessException e){
        Map<String,Object> error=new LinkedHashMap<>();
        error.put(e.getName(),e.getMessage());
        ErrorResponse errorResponse=new ErrorResponse(e.getStatus().toString(),error);
        return ResponseEntity.status(e.getStatus()).body(errorResponse);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> ValidError(MethodArgumentNotValidException e){
        Map<String,Object> response=new LinkedHashMap<>();
        response.put("errors",e.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage)));
        return response;
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse ExceptionError(Exception e){
        Map<String,Object> error=new LinkedHashMap<>();
        error.put("Service",e.getMessage());
        ErrorResponse errorResponse=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(),error);
        return errorResponse;
    }
}
