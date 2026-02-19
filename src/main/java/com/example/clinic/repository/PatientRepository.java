package com.example.clinic.repository;

import com.example.clinic.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findAllByDeletedFalse(Pageable pageable);

    Optional<Patient> findByIdAndDeletedFalse(Long id);

    Page<Patient> findByFirstNameContainingIgnoreCaseAndDeletedFalse(String firstName, Pageable pageable);

    Page<Patient> findByLastNameContainingIgnoreCaseAndDeletedFalse(String lastName, Pageable pageable);
}
