package com.sparta.andbackoffice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.andbackoffice.dto.request.BoardCategoryRequestDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.BoardCategoryResponseDto;
import com.sparta.andbackoffice.service.BoardCategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "BoardCategoryController")
@RequiredArgsConstructor
@RequestMapping("/api/admin/boardcategories")
@RestController
public class BoardCategoryController {

	private final BoardCategoryService boardCategoryService;

	// 카테고리 생성
	@PostMapping("")
	public ResponseEntity<ApiResponseDto> createCategory(@RequestBody BoardCategoryRequestDto requestDto){
		log.info("Controller - create : 시작");

		boardCategoryService.createCategory(requestDto);

		log.info("Controller - create : 끝");
		return ResponseEntity.ok().body(new ApiResponseDto("카테고리 생성 완료", HttpStatus.OK.value()));
	}

	// 카테고리 전체 조회
	@GetMapping("")
	public ResponseEntity<List<BoardCategoryResponseDto>> getCategories(){
		List<BoardCategoryResponseDto> categories = boardCategoryService.getCategories();
		return ResponseEntity.ok(categories);
	}

	// 카테고리 수정
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Long id,
											@RequestBody BoardCategoryRequestDto requestDto){
		log.info("Controller - update : 시작");

		boardCategoryService.updateCategory(id, requestDto);

		log.info("Controller - update : 끝");
		return ResponseEntity.ok().body(new ApiResponseDto("카테고리 수정 완료", HttpStatus.OK.value()));
	}


	// 카테고리 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Long id){
		log.info("Controller - delete : 시작");

		boardCategoryService.deleteCategory(id);

		log.info("Controller - delete : 끝");
		return ResponseEntity.ok().body(new ApiResponseDto("카테고리 삭제 완료", HttpStatus.OK.value()));
	}


}
