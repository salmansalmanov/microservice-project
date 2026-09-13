package com.salman.msproduct.mapper;

import com.salman.msproduct.dto.request.CategoryCreateRequest;
import com.salman.msproduct.dto.request.CategoryUpdateRequest;
import com.salman.msproduct.dto.response.CategoryDetailResponse;
import com.salman.msproduct.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category createRequestToEntity(CategoryCreateRequest categoryCreateRequest);

    CategoryDetailResponse entityToDetailResponse(Category category);

    Category updateRequestToEntity(CategoryUpdateRequest categoryUpdateRequest, @MappingTarget Category category);
}
