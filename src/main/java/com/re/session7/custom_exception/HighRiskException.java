package com.re.session7.custom_exception;

public class HighRiskException extends RuntimeException {
    public HighRiskException(String message) {
        super(message);
    }
}