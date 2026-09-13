package com.salman.msproduct.service.abstraction;

import com.salman.msproduct.dto.request.CategoryCreateRequest;
import com.salman.msproduct.dto.request.CategoryUpdateRequest;
import com.salman.msproduct.dto.response.CategoryDetailResponse;
import com.salman.msproduct.dto.response.PageResponse;
import jakarta.validation.Valid;

public interface CategoryService {
    CategoryDetailResponse createCategory(CategoryCreateRequest categoryCreateRequest);

    PageResponse<CategoryDetailResponse> getAllCategories(int page, int size);

    CategoryDetailResponse getCategoryById(Long id);

    CategoryDetailResponse updateCategoryById(Long id, CategoryUpdateRequest categoryUpdateRequest);

    CategoryDetailResponse deleteCategoryById(Long id);
}
