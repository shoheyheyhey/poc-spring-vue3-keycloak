package com.example.backend.infra.payment.shared.exception;

public class InfraException extends RuntimeException {
    public InfraException(String message) {
        super(message);
    }
}
