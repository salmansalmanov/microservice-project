package com.salman.msproduct.exception.custom;

import com.salman.msproduct.enums.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final ErrorCode code;

    public NotFoundException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }
}
