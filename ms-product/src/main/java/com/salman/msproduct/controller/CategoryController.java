package com.salman.msproduct.controller;

import com.salman.msproduct.dto.request.CategoryCreateRequest;
import com.salman.msproduct.dto.request.CategoryUpdateRequest;
import com.salman.msproduct.dto.response.CategoryDetailResponse;
import com.salman.msproduct.dto.response.PageResponse;
import com.salman.msproduct.service.abstraction.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDetailResponse> createCategory(@RequestBody @Valid CategoryCreateRequest categoryCreateRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.createCategory(categoryCreateRequest));
    }

    @GetMapping
    public ResponseEntity<PageResponse<CategoryDetailResponse>> getAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.getAllCategories(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDetailResponse> getCategoryById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.getCategoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDetailResponse> updateCategoryById(@PathVariable Long id, @RequestBody @Valid CategoryUpdateRequest categoryUpdateRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.updateCategoryById(id, categoryUpdateRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDetailResponse> deleteCategoryById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.deleteCategoryById(id));
    }
}
