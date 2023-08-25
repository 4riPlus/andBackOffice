package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.request.MiddleCategoryRequestDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.MiddleCategoryListResponseDto;
import com.sparta.andbackoffice.dto.response.MiddleCategoryResponseDto;
import com.sparta.andbackoffice.service.MiddleCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MiddleCategoryController {

    private final MiddleCategoryService middleCategoryService;

    //생성
    @PostMapping("/middlecategory")
    public ResponseEntity<ApiResponseDto>createMiddleCategory(@RequestBody MiddleCategoryRequestDto middleCategoryRequestDto){
        middleCategoryService.createMiddleCategory(middleCategoryRequestDto);
        return ResponseEntity.ok().body(new ApiResponseDto("카테고리 생성완료", HttpStatus.OK.value()));
    }

    //조회
    @GetMapping("/middlecategory")
    public ResponseEntity<MiddleCategoryListResponseDto> getMiddleCategory(){
        MiddleCategoryListResponseDto getMiddleCategory = middleCategoryService.getMiddleCategory();
        return ResponseEntity.ok().body(getMiddleCategory);
    }

    //수정
    @PutMapping("/middlecategory/{id}")
    public ResponseEntity<MiddleCategoryResponseDto> updateMiddleCategory(@PathVariable Long id, @RequestBody MiddleCategoryRequestDto middleCategoryRequestDto){
        MiddleCategoryResponseDto updateMiddleCategory = middleCategoryService.updateMiddleCategory(id,middleCategoryRequestDto);
        return ResponseEntity.ok().body(updateMiddleCategory);
    }

    //삭제
    @DeleteMapping("/middlecategory/{id}")
    public ResponseEntity<String> deleteMiddleCategory(@PathVariable Long id){
        String msg = middleCategoryService.deleteMiddleCategory(id);
        return ResponseEntity.ok(msg);
    }



}
