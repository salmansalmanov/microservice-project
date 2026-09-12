package com.salman.msuser.enums;

import com.salman.msuser.exception.custom.BadRequestException;

public enum Status {
    ACTIVE,
    BLOCKED,
    DELETED,
    INACTIVE;

    public static Status fromString(String status) {
        if (status == null || status.isEmpty()) {
            return null;
        }
        try {
            return Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid status value: " + status);
        }
    }
}
