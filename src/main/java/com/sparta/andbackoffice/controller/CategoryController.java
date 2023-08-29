package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.request.CategoryRequestDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.CategoryListResponseDto;
import com.sparta.andbackoffice.dto.response.CategoryResponseDto;
import com.sparta.andbackoffice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class CategoryController {

    private final CategoryService categoryService;

    //카테고리 생성
    @PostMapping("/category")
    public ResponseEntity<ApiResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        categoryService.createCategory(categoryRequestDto);
        return ResponseEntity.ok().body(new ApiResponseDto("카테고리 생성 완료", HttpStatus.OK.value()));
    }

    // 카테고리 전체조회
    @GetMapping("/category")
    public ResponseEntity<CategoryListResponseDto> getCategory() {
        CategoryListResponseDto getCategory = categoryService.getCategory();
        return ResponseEntity.ok().body(getCategory);
    }

    //카테고리 수정
    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDto categoryRequestDto) {
        CategoryResponseDto updateCategory = categoryService.updateCategory(id, categoryRequestDto);
        return ResponseEntity.ok().body(updateCategory);
    }

    //카테고리 삭제
    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        String msg = categoryService.deleteCategory(id);
        return ResponseEntity.ok(msg);
    }
}



