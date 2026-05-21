package com.re.session7.custom_exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({HighRiskException.class, InvalidAddressException.class, IllegalArgumentException.class})
    public ResponseEntity<Map<String, Object>> handleCustomExceptions(Exception ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getClass().getSimpleName());
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("status", 400);
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralExceptions(Exception ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "GeneralException");
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("status", 400);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}

