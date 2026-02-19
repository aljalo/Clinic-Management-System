package com.example.clinic.service;

import com.example.clinic.dto.PatientRequest;
import com.example.clinic.dto.PatientResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface PatientService {

    PatientResponse createPatient(PatientRequest request);

    Page<PatientResponse> getAllPatients(Pageable pageable);

    PatientResponse getPatientById(Long id);

    PatientResponse updatePatient(Long id, PatientRequest request);

    void deletePatient(Long id);

    Page<PatientResponse> searchByName(String name, Pageable pageable);

}
