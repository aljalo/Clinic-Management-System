package com.example.clinic.exception;

import java.time.LocalDateTime;

/**
 * Immutable API error response.
 * No Lombok @Data for architect-level control.
 */
public final class ErrorResponse {

    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;
    private final String errorCode;

    public ErrorResponse(
            LocalDateTime timestamp,
            int status,
            String error,
            String message,
            String path,
            String errorCode) {

        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.errorCode = errorCode;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getError() { return error; }
    public String getMessage() { return message; }
    public String getPath() { return path; }
    public String getErrorCode() { return errorCode; }
}