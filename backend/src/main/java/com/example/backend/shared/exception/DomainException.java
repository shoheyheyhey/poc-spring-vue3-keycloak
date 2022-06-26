package com.example.backend.shared.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
