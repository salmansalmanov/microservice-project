package com.salman.msuser.dto.response;

import com.salman.msuser.enums.Status;

import java.time.Instant;

public record UserDetailResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String street,
        String city,
        String zipCode,
        Status status,
        Instant createdAt
) {
}
