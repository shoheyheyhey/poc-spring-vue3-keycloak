package com.example.backend.shared.exception;

public class InfraException extends RuntimeException {
    public InfraException(String message) {
        super(message);
    }
}
