package com.salman.msproduct.service.concrete;

import com.salman.msproduct.dto.request.CategoryCreateRequest;
import com.salman.msproduct.dto.response.CategoryDetailResponse;
import com.salman.msproduct.entity.Category;
import com.salman.msproduct.exception.AlreadyExistsException;
import com.salman.msproduct.mapper.CategoryMapper;
import com.salman.msproduct.repository.CategoryRepository;
import com.salman.msproduct.service.abstraction.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDetailResponse createCategory(CategoryCreateRequest categoryCreateRequest) {
        if (categoryRepository.existsByName(categoryCreateRequest.name())) {
            throw new AlreadyExistsException("Category already exists");
        }

        Category category = categoryMapper.createRequestToEntity(categoryCreateRequest);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.entityToDetailResponse(savedCategory);
    }
}
