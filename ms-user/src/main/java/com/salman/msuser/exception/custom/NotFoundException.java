package com.salman.msuser.exception.custom;

import com.salman.msuser.enums.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final ErrorCode code;

    public NotFoundException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }
}
