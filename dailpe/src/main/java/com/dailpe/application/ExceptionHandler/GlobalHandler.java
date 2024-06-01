package com.dailpe.application.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse methodArgumentNotValidException(MethodArgumentNotValidException ex){
        ErrorResponse response=ErrorResponse.create(ex, HttpStatus.BAD_REQUEST,ex.getLocalizedMessage());
        return response;
    }
    @ExceptionHandler(NoResourceFoundException.class)
    public ErrorResponse noResourceFoundException(NoResourceFoundException ex){
        return ErrorResponse.create(ex, HttpStatusCode.valueOf(404), "Resource Not Found");
    }

}
