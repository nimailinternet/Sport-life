package org.example.Exceptions;

import lombok.extern.java.Log;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
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
        Map<String,Object> response=new LinkedHashMap<>();
        response.put(e.getName(),e.getMessage());
        System.out.println(response.toString());
        return ResponseEntity.status(e.getStatus()).body(new ErrorResponse(e.getStatus().toString(),response));
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> ValidError(MethodArgumentNotValidException e){
        Map<String,Object> response=new LinkedHashMap<>();
         response =
                e.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .collect(Collectors.toMap(
                                FieldError::getField,
                                FieldError::getDefaultMessage,
                                (a, b) -> a
                        ));
        System.out.println(response.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new ErrorResponse("400",response));
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> ExceptionError(Exception e){
        Map<String,Object> response=new LinkedHashMap<>();
        response.put("500",e.getMessage());
        System.out.println(response.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("500",response));
    }
}
