package com.salman.msproduct.dto.response;

import com.salman.msproduct.enums.ProductStatus;

public record ProductDetailResponse(
        Long id,
        String name,
        String sku,
        String description,
        Double price,
        Integer stockQuantity,
        ProductStatus status,
        CategoryResponse category
) {
}
