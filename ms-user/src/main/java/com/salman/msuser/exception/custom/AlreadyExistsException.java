package com.salman.msuser.exception.custom;

import com.salman.msuser.enums.ErrorCode;
import lombok.Getter;

@Getter
public class AlreadyExistsException extends RuntimeException {
    private final ErrorCode code;

    public AlreadyExistsException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }
}
