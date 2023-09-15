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
@RequestMapping("/api/admin")
public class BottomCategoryController {

    private final BottomCategoryService bottomCategoryService;

    //조회
    @GetMapping("/bottomcategory")
    public ResponseEntity<BottomCategoryListResponseDto> getBottomCategory() {
        BottomCategoryListResponseDto getBottomCategory = bottomCategoryService.getBottomCategory();
        return ResponseEntity.ok().body(getBottomCategory);
    }

    //생성
//    @PostMapping("/bottomcategory")
//    public ResponseEntity<BottomCategoryResponseDto> createBottomCategory(@RequestBody BottomCategoryRequestDto bottomCategoryRequestDto) {
//        BottomCategoryResponseDto createBottomCategory = bottomCategoryService.createBottomCategory(bottomCategoryRequestDto);
//        return ResponseEntity.ok().body(createBottomCategory);
//    }
    @PostMapping("/bottomcategory")
    public ResponseEntity<ApiResponseDto> createBottomCategory(@RequestBody BottomCategoryRequestDto bottomCategoryRequestDto) {
//        Long middleCategoryId = bottomCategoryRequestDto.getMiddleCategoryId(); // 중위 카테고리 ID 가져오기
//
//        MiddleCategory middleCategory = middleCategoryRepository.findById(middleCategoryId)
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 중위 카테고리입니다."));
//
//        String categoryName = bottomCategoryRequestDto.getCategoryName();
//        BottomCategory bottomCategory = new BottomCategory(categoryName);
//        bottomCategory.setMiddleCategory(middleCategory); // 중위 카테고리와의 연관 관계 설정
//        bottomCategoryRepository.save(bottomCategory);
//
//        BottomCategoryResponseDto responseDto = new BottomCategoryResponseDto(bottomCategory);
        bottomCategoryService.createBottomCategory(bottomCategoryRequestDto);
        return ResponseEntity.ok().body(new ApiResponseDto("하위 카테고리 생성 완료", HttpStatus.OK.value()));
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