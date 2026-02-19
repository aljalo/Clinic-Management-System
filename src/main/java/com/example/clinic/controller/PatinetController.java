package com.example.clinic.controller;

import com.example.clinic.dto.PatientRequest;
import com.example.clinic.entity.Patient;
import com.example.clinic.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PatinetController {

    private final PatientService patientService;

    @PostMapping
    public Patient create(@Valid @RequestBody PatientRequest request){
        return patientService.createPatient(request);
    }

    @GetMapping
    public List<Patient> getAll(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        patientService.deletePatientById(id);
    }
}
