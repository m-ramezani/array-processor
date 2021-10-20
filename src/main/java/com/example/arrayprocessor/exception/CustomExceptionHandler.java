package com.example.arrayprocessor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@SuppressWarnings("unused")
public class CustomExceptionHandler {

    @ExceptionHandler(ArrayIsEmptyException.class)
    @ResponseBody
    public ResponseEntity<Object> handle(ArrayIsEmptyException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ArrayIsEmptyException(exception.getMessage()));
    }

}
