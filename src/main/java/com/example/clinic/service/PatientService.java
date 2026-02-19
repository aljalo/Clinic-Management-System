package com.example.clinic.service;

import com.example.clinic.dto.PatientRequest;
import com.example.clinic.entity.Patient;

import java.util.List;

public interface PatientService {

    Patient createPatient(PatientRequest request);

    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    void deletePatientById(Long id);
}
