package org.example.Exceptions;

import org.springframework.http.HttpStatus;
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
    public Map<String,Object> BusinessError(BusinessException e){
        LinkedHashMap<String,Object> error=new LinkedHashMap<>();
        error.put("status",e.getStatus());
        error.put("error",e.getMessage());
        return error;
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
    public Map<String,Object> ExceptionError(Exception e){
        Map<String,Object> error=new LinkedHashMap<>();
        error.put("error",e.getMessage());
        return error;
    }
}
