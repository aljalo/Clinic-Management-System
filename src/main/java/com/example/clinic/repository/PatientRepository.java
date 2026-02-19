package com.example.clinic.repository;

import com.example.clinic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientRepository
        extends JpaRepository<Patient, Long>,
        JpaSpecificationExecutor<Patient> {

    Page<Patient> findByFirstNameContainingIgnoreCase(String name, Pageable pageable);
}
