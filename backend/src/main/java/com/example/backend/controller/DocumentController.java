package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    // @GetMapping("/document")
    // @PreAuthorize("hasAuthority('SCOPE_read')")
    // public String document(@AuthenticationPrincipal Jwt jwt) {
    //     jwt.getClaims().forEach((k, v) -> System.out.printf("Claim :%s \t Value :%s%n", k, v));
    //     return "document-1";
    // }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("UP");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello () { return ResponseEntity.ok("hello springboot world");}

}