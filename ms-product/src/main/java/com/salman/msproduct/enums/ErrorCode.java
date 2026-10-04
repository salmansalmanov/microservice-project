package com.salman.msproduct.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    CATEGORY_ALREADY_EXISTS("Category already exists"),
    CATEGORY_NOT_FOUND("Category not found"),;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
