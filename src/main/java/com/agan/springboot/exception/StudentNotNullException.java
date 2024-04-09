package com.agan.springboot.exception;

public class StudentNotNullException extends RuntimeException {

    public StudentNotNullException(String message) {
        super(message);
    }
}
