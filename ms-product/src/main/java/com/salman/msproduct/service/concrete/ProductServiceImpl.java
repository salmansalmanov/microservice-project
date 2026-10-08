package com.salman.msproduct.service.concrete;

import com.salman.msproduct.dto.request.ProductCreateRequest;
import com.salman.msproduct.dto.response.PageResponse;
import com.salman.msproduct.dto.response.ProductDetailResponse;
import com.salman.msproduct.dto.response.ProductResponse;
import com.salman.msproduct.entity.Category;
import com.salman.msproduct.entity.Product;
import com.salman.msproduct.enums.ErrorCode;
import com.salman.msproduct.exception.custom.NotFoundException;
import com.salman.msproduct.mapper.ProductMapper;
import com.salman.msproduct.repository.CategoryRepository;
import com.salman.msproduct.repository.ProductRepository;
import com.salman.msproduct.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDetailResponse createProduct(ProductCreateRequest productCreateRequest) {
        Category category = categoryRepository.findById(productCreateRequest.categoryId())
                .orElseThrow(() -> new NotFoundException(ErrorCode.CATEGORY_NOT_FOUND.getMessage(), ErrorCode.CATEGORY_NOT_FOUND));
        Product product = productMapper.createRequestToEntity(productCreateRequest);
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDetailResponse(savedProduct);
    }

    @Override
    public ProductDetailResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.PRODUCT_NOT_FOUND.getMessage(), ErrorCode.PRODUCT_NOT_FOUND));
        return productMapper.toDetailResponse(product);
    }

    @Override
    public PageResponse<ProductResponse> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Product> productPage = productRepository.findAll(pageable);
        return PageResponse.of(productPage.map(productMapper::toResponse));
    }
}
