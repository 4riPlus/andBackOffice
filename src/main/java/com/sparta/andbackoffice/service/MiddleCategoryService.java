package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.request.MiddleCategoryRequestDto;
import com.sparta.andbackoffice.dto.response.MiddleCategoryDetailsDto;
import com.sparta.andbackoffice.dto.response.MiddleCategoryListResponseDto;
import com.sparta.andbackoffice.dto.response.MiddleCategoryResponseDto;
import com.sparta.andbackoffice.entity.MiddleCategory;
import com.sparta.andbackoffice.repository.MiddleCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MiddleCategoryService {
	private final MiddleCategoryRepository middleCategoryRepository;

	//상세조회
	public MiddleCategoryDetailsDto getMiddleCategoryDetails(Long id){
		MiddleCategory middleCategory = middleCategoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("MiddleCategory ID를 찾을 수 없습니다."+id));
				return new MiddleCategoryDetailsDto(middleCategory);
	}

	//조회
	public MiddleCategoryListResponseDto getMiddleCategory() {
		List<MiddleCategoryResponseDto> middleCategoryList = middleCategoryRepository.findAll().stream()
				.map(MiddleCategoryResponseDto::new)
				.collect(Collectors.toList());
		return new MiddleCategoryListResponseDto(middleCategoryList);
	}

	//생성
	public void createMiddleCategory(MiddleCategoryRequestDto middleCategoryRequestDto) {
		String CategoryName = middleCategoryRequestDto.getCategoryName();
		MiddleCategory middleCategory = new MiddleCategory(CategoryName);
		middleCategoryRepository.save(middleCategory);
	}


	//수정
	@Transactional
	public MiddleCategoryResponseDto updateMiddleCategory(Long id, MiddleCategoryRequestDto middleCategoryRequestDto) {
		MiddleCategory middleCategory = findById(id);
		middleCategory.setCategoryName(middleCategoryRequestDto.getCategoryName());
		return new MiddleCategoryResponseDto(middleCategory);
	}

	//삭제
	@Transactional
	public String deleteMiddleCategory(Long id) {
		MiddleCategory middleCategory = findById(id);
		middleCategoryRepository.delete(middleCategory);
		return "카테고리 삭제완료";
	}

	private MiddleCategory findById(Long id) {
		return middleCategoryRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 카테고리를 찾을 수 없습니다.")
		);
	}
}


