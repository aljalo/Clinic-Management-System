package com.example.clinic.service.impl;

import com.example.clinic.dto.PatientRequest;
import com.example.clinic.dto.PatientResponse;
import com.example.clinic.entity.Patient;
import com.example.clinic.exception.UserNotFoundException;
import com.example.clinic.mapper.PatientMapper;
import com.example.clinic.repository.PatientRepository;
import com.example.clinic.service.PatientService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.example.clinic.specification.PatientSpecification.*;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    // ================================
    // CREATE
    // ================================

    @Override
    public PatientResponse createPatient(PatientRequest request) {
        Patient patient = patientMapper.toEntity(request);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toResponse(savedPatient);
    }

    // ================================
    // READ
    // ================================

    @Override
    public Page<PatientResponse> getAllPatients(Pageable pageable) {
        return patientRepository.findAll(pageable)
                .map(patientMapper::toResponse);
    }

    @Override
    public PatientResponse getPatientById(Long id) {
        return patientMapper.toResponse(findPatientById(id));
    }

    @Override
    public Page<PatientResponse> searchByName(String name, Pageable pageable) {
        return patientRepository
                .findByFirstNameContainingIgnoreCase(name, pageable)
                .map(patientMapper::toResponse);
    }

    // ================================
    // UPDATE
    // ================================

    @Override
    public PatientResponse updatePatient(Long id, PatientRequest request) {
        Patient patient = findPatientById(id);

        patientMapper.updateEntityFromRequest(request, patient);

        Patient updatedPatient = patientRepository.save(patient);

        return patientMapper.toResponse(updatedPatient);
    }

    // ================================
    // DELETE (Soft Delete)
    // ================================

    @Override
    public void deletePatient(Long id) {
        Patient patient = findPatientById(id);
        patient.setDeleted(true);
        patientRepository.save(patient);
    }

    // ================================
    // DYNAMIC FILTERING
    // ================================

    @Override
    public Page<PatientResponse> filterPatients(
            String firstName,
            String lastName,
            String email,
            LocalDate fromDate,
            LocalDate toDate,
            Pageable pageable) {

        Specification<Patient> spec = Specification.where(null);

        if (firstName != null && !firstName.isBlank()) {
            spec = spec.and(firstNameContains(firstName));
        }

        if (lastName != null && !lastName.isBlank()) {
            spec = spec.and(lastNameContains(lastName));
        }

        if (email != null && !email.isBlank()) {
            spec = spec.and(emailEquals(email));
        }

        if (fromDate != null) {
            spec = spec.and(bornAfter(fromDate));
        }

        if (toDate != null) {
            spec = spec.and(bornBefore(toDate));
        }

        return patientRepository.findAll(spec, pageable)
                .map(patientMapper::toResponse);
    }

    // ================================
    // PRIVATE HELPER
    // ================================

    private Patient findPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("Patient with id " + id + " not found"));
    }
}
