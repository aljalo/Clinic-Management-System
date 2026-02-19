package com.example.clinic.repository;

import com.example.clinic.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findByFirstNameContainingIgnoreCase(String firstName, Pageable pageable);

}
