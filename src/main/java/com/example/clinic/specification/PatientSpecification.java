package com.example.clinic.specification;

import com.example.clinic.entity.Patient;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class PatientSpecification {

    public static Specification<Patient> firstNameContains(String firstName) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("firstName")),
                        "%" + firstName.toLowerCase() + "%");
    }

    public static Specification<Patient> lastNameContains(String lastName) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("lastName")),
                        "%" + lastName.toLowerCase() + "%");
    }

    public static Specification<Patient> emailEquals(String email) {
        return (root, query, cb) ->
                cb.equal(root.get("email"), email);
    }

    public static Specification<Patient> bornAfter(LocalDate date) {
        return (root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("dateOfBirth"), date);
    }

    public static Specification<Patient> bornBefore(LocalDate date) {
        return (root, query, cb) ->
                cb.lessThanOrEqualTo(root.get("dateOfBirth"), date);
    }
}
