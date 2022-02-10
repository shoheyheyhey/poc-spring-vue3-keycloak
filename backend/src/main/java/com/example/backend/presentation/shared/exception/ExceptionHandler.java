package com.example.backend.presentation.shared.exception;

import com.example.backend.domain.shared.exception.DomainException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({DomainException.class})
    public ResponseEntity handleDomainException(DomainException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
