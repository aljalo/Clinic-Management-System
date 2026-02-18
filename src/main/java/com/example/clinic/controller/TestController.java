package com.example.clinic.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminEndpoint() {
        return "Hello Admin!";
    }

    @GetMapping("/doctor")
    @PreAuthorize("hasRole('DOCTOR')")
    public String doctorEndpoint() {
        return "Hello Doctor!";
    }

    @GetMapping("/reception")
    @PreAuthorize("hasRole('RECEPTIONIST')")
    public String receptionEndpoint() {
        return "Hello Receptionist!";
    }
}