package com.salman.msproduct.service.concrete;

import com.salman.msproduct.dto.request.CategoryCreateRequest;
import com.salman.msproduct.dto.request.CategoryUpdateRequest;
import com.salman.msproduct.dto.response.CategoryDetailResponse;
import com.salman.msproduct.dto.response.PageResponse;
import com.salman.msproduct.entity.Category;
import com.salman.msproduct.enums.ErrorCode;
import com.salman.msproduct.exception.custom.AlreadyExistsException;
import com.salman.msproduct.exception.custom.NotFoundException;
import com.salman.msproduct.mapper.CategoryMapper;
import com.salman.msproduct.repository.CategoryRepository;
import com.salman.msproduct.service.abstraction.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDetailResponse createCategory(CategoryCreateRequest categoryCreateRequest) {
        if (categoryRepository.existsByName(categoryCreateRequest.name())) {
            throw new AlreadyExistsException(ErrorCode.CATEGORY_ALREADY_EXISTS.getMessage(), ErrorCode.CATEGORY_ALREADY_EXISTS);
        }

        Category category = categoryMapper.createRequestToEntity(categoryCreateRequest);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.entityToDetailResponse(savedCategory);
    }

    @Override
    public PageResponse<CategoryDetailResponse> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        return PageResponse.of(categoryPage.map(categoryMapper::entityToDetailResponse));
    }

    @Override
    public CategoryDetailResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CATEGORY_NOT_FOUND.getMessage(), ErrorCode.CATEGORY_NOT_FOUND));
        return categoryMapper.entityToDetailResponse(category);
    }

    @Override
    public CategoryDetailResponse updateCategoryById(Long id, CategoryUpdateRequest categoryUpdateRequest) {
        if (categoryRepository.existsByName(categoryUpdateRequest.name())) {
            throw new AlreadyExistsException(ErrorCode.CATEGORY_ALREADY_EXISTS.getMessage(), ErrorCode.CATEGORY_ALREADY_EXISTS);
        }

        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CATEGORY_NOT_FOUND.getMessage(), ErrorCode.CATEGORY_NOT_FOUND));
        Category updatedCategory = categoryMapper.updateRequestToEntity(categoryUpdateRequest, existingCategory);
        Category savedCategory = categoryRepository.save(updatedCategory);
        return categoryMapper.entityToDetailResponse(savedCategory);
    }

    @Override
    public CategoryDetailResponse deleteCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.CATEGORY_NOT_FOUND.getMessage(), ErrorCode.CATEGORY_NOT_FOUND));
        category.setName(category.getName() + "_deleted_" + System.currentTimeMillis());
        category.setDeletedAt(Instant.now());
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.entityToDetailResponse(savedCategory);
    }
}
