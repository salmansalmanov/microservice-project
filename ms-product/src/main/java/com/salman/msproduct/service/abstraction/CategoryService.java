package com.salman.msproduct.service.abstraction;

import com.salman.msproduct.dto.request.CategoryCreateRequest;
import com.salman.msproduct.dto.response.CategoryDetailResponse;

public interface CategoryService {
    CategoryDetailResponse createCategory(CategoryCreateRequest categoryCreateRequest);
}
