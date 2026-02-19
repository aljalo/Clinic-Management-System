package com.example.clinic.service.impl;

import com.example.clinic.dto.PatientRequest;
import com.example.clinic.entity.Patient;
import com.example.clinic.exception.UserNotFoundException;
import com.example.clinic.repository.PatientRepository;
import com.example.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient createPatient(PatientRequest request){

        Patient patient = Patient.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhoneNumber())
                .email(request.getEmail())
                .dateOfBirth(request.getDateOfBirth())
                .build();

        return patientRepository.save(patient);
    }
    @Override
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id){
        return patientRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Patient not found"));
    }
    @Override
    public void deletePatientById(Long id){
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
    }
}
