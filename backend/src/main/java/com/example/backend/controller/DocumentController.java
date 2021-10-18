package com.example.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class DocumentController {

    @GetMapping("/document")
    @PreAuthorize("hasAuthority('SCOPE_read')")
    public String document(@AuthenticationPrincipal Jwt jwt) {
        jwt.getClaims().forEach((k, v) -> System.out.printf("Claim :%s \t Value :%s%n", k, v));
        return "document-1";
    }
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("UP");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello () { return ResponseEntity.ok("hello springboot world");}

}