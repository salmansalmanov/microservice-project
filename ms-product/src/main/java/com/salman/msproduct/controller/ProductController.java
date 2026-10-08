package com.salman.msproduct.controller;

import com.salman.msproduct.dto.request.ProductCreateRequest;
import com.salman.msproduct.dto.request.ProductUpdateRequest;
import com.salman.msproduct.dto.response.PageResponse;
import com.salman.msproduct.dto.response.ProductDetailResponse;
import com.salman.msproduct.dto.response.ProductResponse;
import com.salman.msproduct.service.abstraction.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDetailResponse> createProduct(@RequestBody @Valid ProductCreateRequest productCreateRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(productCreateRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<PageResponse<ProductResponse>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getAllProducts(page, size));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDetailResponse> updateProductById(@PathVariable Long id, @RequestBody @Valid ProductUpdateRequest productUpdateRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.updateProductById(id, productUpdateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDetailResponse> deleteProductById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.deleteProductById(id));
    }
}
