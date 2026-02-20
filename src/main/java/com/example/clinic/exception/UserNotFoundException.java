package com.example.clinic.exception;

import org.springframework.http.HttpStatus;

/**
 * Thrown when user entity is not found.
 */
public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(String username) {
        super(
                "User not found with username: " + username,
                ErrorCode.USER_NOT_FOUND,
                HttpStatus.NOT_FOUND
        );
    }
}