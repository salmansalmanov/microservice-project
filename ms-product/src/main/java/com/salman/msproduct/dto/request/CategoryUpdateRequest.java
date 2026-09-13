package com.salman.msproduct.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CategoryUpdateRequest(
        @NotBlank(message = "Name cannot be blank")
        String name
) {
}
