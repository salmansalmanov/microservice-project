package com.salman.msproduct.mapper;

import com.salman.msproduct.dto.request.ProductCreateRequest;
import com.salman.msproduct.dto.request.ProductUpdateRequest;
import com.salman.msproduct.dto.response.ProductDetailResponse;
import com.salman.msproduct.dto.response.ProductResponse;
import com.salman.msproduct.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mapping(target = "status", constant = "ACTIVE")
    Product createRequestToEntity(ProductCreateRequest productCreateRequest);

    ProductDetailResponse toDetailResponse(Product product);

    ProductResponse toResponse(Product product);

    Product updateRequestToEntity(ProductUpdateRequest productUpdateRequest, @MappingTarget Product product);
}
