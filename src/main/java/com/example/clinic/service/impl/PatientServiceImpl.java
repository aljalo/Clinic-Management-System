package com.example.clinic.service.impl;

import com.example.clinic.dto.PatientRequest;
import com.example.clinic.dto.PatientResponse;
import com.example.clinic.entity.Patient;
import com.example.clinic.exception.UserNotFoundException;
import com.example.clinic.mapper.PatientMapper;
import com.example.clinic.repository.PatientRepository;
import com.example.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public PatientResponse createPatient(PatientRequest request) {

        Patient patient = patientMapper.toEntity(request);
        Patient saved = patientRepository.save(patient);

        return patientMapper.toResponse(saved);
    }

    @Override
    public Page<PatientResponse> getAllPatients(Pageable pageable) {

        return patientRepository.findAll(pageable)
                .map(patientMapper::toResponse);
    }

@Override
public PatientResponse getPatientById(Long id) {

    Patient patient = patientRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Patient not found"));

    return patientMapper.toResponse(patient);
}


    @Override
    public PatientResponse updatePatient(Long id, PatientRequest request) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Patient not found"));

        patientMapper.updateEntityFromRequest(request, patient);

        Patient updated = patientRepository.save(patient);

        return patientMapper.toResponse(updated);
    }
    @Override
    public Page<PatientResponse> searchByName(String name, Pageable pageable) {
        return patientRepository
                .findByFirstNameContainingIgnoreCase(name, pageable)
                .map(patientMapper::toResponse);
    }

    @Override
    public void deletePatient(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Patient not found"));

        patient.setDeleted(true);
        patientRepository.save(patient);
    }

}
