package com.salman.msproduct.service.abstraction;

import com.salman.msproduct.dto.request.ProductCreateRequest;
import com.salman.msproduct.dto.response.ProductDetailResponse;

public interface ProductService {
    ProductDetailResponse createProduct(ProductCreateRequest productCreateRequest);

    ProductDetailResponse getProductById(Long id);
}
