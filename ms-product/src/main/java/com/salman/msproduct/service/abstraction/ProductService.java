package com.salman.msproduct.service.abstraction;

import com.salman.msproduct.dto.request.ProductCreateRequest;
import com.salman.msproduct.dto.request.ProductUpdateRequest;
import com.salman.msproduct.dto.response.PageResponse;
import com.salman.msproduct.dto.response.ProductDetailResponse;
import com.salman.msproduct.dto.response.ProductResponse;

public interface ProductService {
    ProductDetailResponse createProduct(ProductCreateRequest productCreateRequest);

    ProductDetailResponse getProductById(Long id);

    PageResponse<ProductResponse> getAllProducts(int page, int size);

    ProductDetailResponse updateProductById(Long id, ProductUpdateRequest productUpdateRequest);

    ProductDetailResponse deleteProductById(Long id);
}
