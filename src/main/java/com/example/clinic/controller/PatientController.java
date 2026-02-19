package com.example.clinic.controller;

import com.example.clinic.dto.PageResponse;
import com.example.clinic.dto.PatientRequest;
import com.example.clinic.dto.PatientResponse;
import com.example.clinic.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PatientResponse create(@Valid @RequestBody PatientRequest request) {
        return patientService.createPatient(request);
    }

    @GetMapping
    public PageResponse<PatientResponse> getAll(Pageable pageable) {
        return PageResponse.from( patientService.getAllPatients(pageable));
    }

    @GetMapping("/{id}")
    public PatientResponse getById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PutMapping("/{id}")
    public PatientResponse update(
            @PathVariable Long id,
            @Valid @RequestBody PatientRequest request) {

        return patientService.updatePatient(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
