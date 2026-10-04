package com.salman.msuser.exception.custom;

import com.salman.msuser.enums.ErrorCode;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {
    private final ErrorCode code;

    public BadRequestException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }
}
