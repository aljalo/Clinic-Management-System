package com.example.clinic.controller;

import com.example.clinic.dto.PatientRequest;
import com.example.clinic.dto.PatientResponse;
import com.example.clinic.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * API Version 1 - Patient Controller
 * Architect-level controller using Pageable abstraction
 */
@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    /**
     * Create new patient
     */
    @PostMapping
    public PatientResponse createPatient(
            @Valid @RequestBody PatientRequest request) {

        return patientService.createPatient(request);
    }

    /**
     * Get all patients with pagination
     * Pageable injected automatically by Spring
     */
    @GetMapping
    public Page<PatientResponse> getAllPatients(Pageable pageable) {

        return patientService.getAllPatients(pageable);
    }

    /**
     * Get patient by id
     */
    @GetMapping("/{id}")
    public PatientResponse getPatientById(@PathVariable Long id) {

        return patientService.getPatientById(id);
    }

    /**
     * Update patient
     */
    @PutMapping("/{id}")
    public PatientResponse updatePatient(
            @PathVariable Long id,
            @Valid @RequestBody PatientRequest request) {

        return patientService.updatePatient(id, request);
    }

    /**
     * Soft delete patient
     */
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {

        patientService.deletePatient(id);
    }
}