package com.salman.msproduct.dto.response;

import com.salman.msproduct.enums.ProductStatus;

import java.math.BigDecimal;

public record ProductDetailResponse(
        Long id,
        String name,
        String sku,
        String description,
        BigDecimal price,
        Integer stockQuantity,
        ProductStatus status,
        CategoryResponse category
) {
}
