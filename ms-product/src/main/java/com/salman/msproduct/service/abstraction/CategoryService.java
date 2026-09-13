package com.salman.msproduct.service.abstraction;

import com.salman.msproduct.dto.request.CategoryCreateRequest;
import com.salman.msproduct.dto.response.CategoryDetailResponse;
import com.salman.msproduct.dto.response.PageResponse;

public interface CategoryService {
    CategoryDetailResponse createCategory(CategoryCreateRequest categoryCreateRequest);

    PageResponse<CategoryDetailResponse> getAllCategories(int page, int size);
}
