package com.salman.msuser.dto.response;

import com.salman.msuser.enums.Status;

public record UserSummaryResponse(
        String id,
        String firstName,
        String lastName,
        Status status
) {
}
