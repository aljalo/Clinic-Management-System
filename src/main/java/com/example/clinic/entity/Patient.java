package com.example.clinic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "patients")
@Where(clause = "deleted = false")
public class Patient extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
}
