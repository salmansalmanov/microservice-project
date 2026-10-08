package com.salman.msproduct.service.abstraction;

import com.salman.msproduct.dto.request.CategoryCreateRequest;
import com.salman.msproduct.dto.request.CategoryUpdateRequest;
import com.salman.msproduct.dto.response.CategoryResponse;
import com.salman.msproduct.dto.response.PageResponse;

public interface CategoryService {
    CategoryResponse createCategory(CategoryCreateRequest categoryCreateRequest);

    PageResponse<CategoryResponse> getAllCategories(int page, int size);

    CategoryResponse getCategoryById(Long id);

    CategoryResponse updateCategoryById(Long id, CategoryUpdateRequest categoryUpdateRequest);

    CategoryResponse deleteCategoryById(Long id);
}
