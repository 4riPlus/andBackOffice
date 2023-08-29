package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.request.BottomCategoryRequestDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.BottomCategoryListResponseDto;
import com.sparta.andbackoffice.dto.response.BottomCategoryResponseDto;
import com.sparta.andbackoffice.service.BottomCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class BottomCategoryController {

    private final BottomCategoryService bottomCategoryService;

    //조회
    @GetMapping("/bottomcategory")
    public ResponseEntity<BottomCategoryListResponseDto> getBottomCategory() {
        BottomCategoryListResponseDto getBottomCategory = bottomCategoryService.getBottomCategory();
        return ResponseEntity.ok().body(getBottomCategory);
    }

    //생성
    @PostMapping("/bottomcategory")
    public ResponseEntity<ApiResponseDto> createBottomCategory(@RequestBody BottomCategoryRequestDto bottomCategoryRequestDto) {
        bottomCategoryService.createBottomCategory(bottomCategoryRequestDto);
        return ResponseEntity.ok().body(new ApiResponseDto("카테고리 생성완료", HttpStatus.OK.value()));
    }

    //수정
    @PutMapping("/bottomcategory/{id}")
    public ResponseEntity<BottomCategoryResponseDto> updateBottomCategory(@PathVariable Long id, @RequestBody BottomCategoryRequestDto bottomCategoryRequestDto) {
        BottomCategoryResponseDto updateBottomCategory = bottomCategoryService.updateBottomCategory(id, bottomCategoryRequestDto);
        return ResponseEntity.ok().body(updateBottomCategory);
    }

    //삭제

    @DeleteMapping("/bottomcategory/{id}")
    public ResponseEntity<String> deleteBottomCategory(@PathVariable Long id) {
        String msg = bottomCategoryService.deleteBottomCategory(id);
        return ResponseEntity.ok(msg);
    }

}
