package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.request.BottomCategoryRequestDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.BottomCategoryListResponseDto;
import com.sparta.andbackoffice.dto.response.BottomCategoryResponseDto;
import com.sparta.andbackoffice.entity.BottomCategory;
import com.sparta.andbackoffice.entity.MiddleCategory;
import com.sparta.andbackoffice.repository.BottomCategoryRepository;
import com.sparta.andbackoffice.repository.MiddleCategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BottomCategoryService {
	private final BottomCategoryRepository bottomCategoryRepository;
	private final MiddleCategoryRepository middleCategoryRepository;

	//생성
	public void createBottomCategory(BottomCategoryRequestDto bottomCategoryRequestDto) {
//      String CategoryName = bottomCategoryRequestDto.getCategoryName();
//      BottomCategory bottomCategory = new BottomCategory(CategoryName);
//      bottomCategoryRepository.save(bottomCategory);
		Long middleCategoryId = bottomCategoryRequestDto.getMiddleCategoryId(); // 중위 카테고리 ID 가져오기

		MiddleCategory middleCategory = middleCategoryRepository.findById(middleCategoryId)
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 중위 카테고리입니다."));

		String categoryName = bottomCategoryRequestDto.getCategoryName();
		BottomCategory bottomCategory = new BottomCategory(categoryName);
		bottomCategory.setMiddleCategory(middleCategory); // 중위 카테고리와의 연관 관계 설정
		bottomCategoryRepository.save(bottomCategory);

		BottomCategoryResponseDto responseDto = new BottomCategoryResponseDto(bottomCategory);
	}

	//조회
	public BottomCategoryListResponseDto getBottomCategory() {
		List<BottomCategoryResponseDto> bottomCategoryList = bottomCategoryRepository.findAll().stream()
				.map(BottomCategoryResponseDto::new)
				.collect(Collectors.toList());
		return new BottomCategoryListResponseDto(bottomCategoryList);
	}

	//수정
	@Transactional
	public BottomCategoryResponseDto updateBottomCategory(Long id, BottomCategoryRequestDto bottomCategoryRequestDto) {
		BottomCategory bottomCategory = findById(id);
		bottomCategory.setCategoryName(bottomCategoryRequestDto.getCategoryName());
		return new BottomCategoryResponseDto(bottomCategory);
	}

	//삭제
	@Transactional
	public String deleteBottomCategory(Long id) {
		BottomCategory bottomCategory = findById(id);
		bottomCategoryRepository.delete(bottomCategory);
		return "카테고리 삭제완료";
	}

	public BottomCategory findById(Long id) {
		return bottomCategoryRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 카테고리를 찾을 수 없습니다.")
		);

	}
}