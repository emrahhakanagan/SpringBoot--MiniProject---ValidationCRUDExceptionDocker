package com.agan.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;
}
