package com.salman.msproduct.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateRequest(
        @NotBlank(message = "Name cannot be blank")
        String name
) {
}
