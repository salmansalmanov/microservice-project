package com.salman.msuser.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    EMAIL_ALREADY_EXISTS("Email already exists"),
    PHONE_NUMBER_ALREADY_EXISTS("Phone number already exists"),
    INVALID_STATUS_VALUE("Invalid status value"),
    USER_NOT_FOUND("User not found"),
    VALIDATION_FAILED("Validation failed"),
    INTERNAL_SERVER_ERROR("An unexpected error occurred");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
