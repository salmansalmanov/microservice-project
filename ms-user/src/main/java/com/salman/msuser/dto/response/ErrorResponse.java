package com.salman.msuser.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.salman.msuser.enums.ErrorCode;

import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse<T>(
        ErrorCode code,
        String message,
        Instant timestamp,
        T details
) {
    public static ErrorResponse<Void> of(ErrorCode code, String message) {
        return new ErrorResponse<>(code, message, Instant.now(), null);
    }

    public static <T> ErrorResponse<T> of(ErrorCode code, String message, T details) {
        return new ErrorResponse<>(code, message, Instant.now(), details);
    }
}
