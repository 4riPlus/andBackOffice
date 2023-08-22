package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.request.CategoryRequestDto;
import com.sparta.andbackoffice.dto.response.CategoryListResponseDto;
import com.sparta.andbackoffice.dto.response.CategoryResponseDto;
import com.sparta.andbackoffice.entity.Category;
import com.sparta.andbackoffice.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository categoryRepository;

	//카테고리 전체조회
	public CategoryListResponseDto getCategory() {
		List<CategoryResponseDto> categoryList = categoryRepository.findAll().stream()
				.map(CategoryResponseDto::new)
				.collect(Collectors.toList());

		return new CategoryListResponseDto(categoryList);
	}

	//카테고리생성
	public void createCategory(CategoryRequestDto categoryRequestDto) {
		String categoryName = categoryRequestDto.getCategoryName();

		Category category = new Category(categoryName);

		categoryRepository.save(category);
	}

	//카테고리 수정

	public CategoryResponseDto updateCategory(Long id, CategoryRequestDto categoryRequestDto) {
		// 카테고리 아이디로 카테고리를 먼저 받아오기
		Category category = findById(id);

		//세터를 사용
		category.setCategoryName(categoryRequestDto.getCategoryName());

		return new CategoryResponseDto(category);
	}

	//카테고리 삭제
	@Transactional
	public String deleteCategory(Long id) {
		Category category = findById(id);
		categoryRepository.delete(category);
		return "카테고리 삭제완료";
	}

	private Category findById(Long id) {
		return categoryRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 카테고리를 찾을 수 없습니다.")
		);
	}

}
