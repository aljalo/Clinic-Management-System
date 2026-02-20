package com.example.clinic.exception;

/**
 * Centralized error codes for the entire application.
 * This allows versioning and consistent API error responses.
 */
public enum ErrorCode {

    USER_NOT_FOUND,
    PATIENT_NOT_FOUND,
    DUPLICATE_USER,
    VALIDATION_ERROR,
    UNAUTHORIZED,
    INTERNAL_SERVER_ERROR

}