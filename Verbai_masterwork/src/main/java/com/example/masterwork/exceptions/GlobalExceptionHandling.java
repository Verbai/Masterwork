package com.example.masterwork.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(com.example.masterwork.exceptions.ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(com.example.masterwork.exceptions.ResourceNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(com.example.masterwork.exceptions.InvalidFieldException.class)
    public ResponseEntity<Object> handleInvalid(com.example.masterwork.exceptions.InvalidFieldException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<Object> handleExist(ResourceAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(ServerNotAvailableException.class)
    public ResponseEntity<Object> handleServer(ServerNotAvailableException exception) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(exception.getMessage());
    }
}
