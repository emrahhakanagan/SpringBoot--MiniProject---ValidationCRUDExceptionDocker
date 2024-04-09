package com.agan.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentNotNullException.class)
    public ResponseEntity<?> studentNotNull(StudentNotNullException studentNotNullException) {
        List<String> details = new ArrayList<>();
        details.add(studentNotNullException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("StudentNotNullException", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> studentNotFound(StudentNotFoundException studentNotFoundException) {
        List<String> details = new ArrayList<>();
        details.add(studentNotFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("StudentNotFound", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
