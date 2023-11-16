package com.sparta.andbackoffice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sparta.andbackoffice.dto.request.BoardCategoryRequestDto;
import com.sparta.andbackoffice.dto.response.BoardCategoryResponseDto;
import com.sparta.andbackoffice.entity.BoardCategory;
import com.sparta.andbackoffice.repository.BoardCategoryRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "BoardCategory Service")
@RequiredArgsConstructor
@Service
public class BoardCategoryService {

	private final BoardCategoryRepository boardCategoryRepository;

	// 카테고리 생성
	@Transactional
	public void createCategory(BoardCategoryRequestDto requestDto) {
		log.info("Service - create : 시작");

		BoardCategory boardCategory = new BoardCategory(requestDto);
		boardCategoryRepository.save(boardCategory);

		log.info("Service - create : 끝");
	}

	// 카테고리 전체 조회
	public List<BoardCategoryResponseDto> getCategories() {
		List<BoardCategory> boardCategories = boardCategoryRepository.findAll();
		return boardCategories.stream().map(BoardCategoryResponseDto::new).collect(Collectors.toList());
	}

	// 카테고리 수정
	@Transactional
	public void updateCategory(Long id, BoardCategoryRequestDto requestDto) {
		BoardCategory boardCategory = boardCategoryRepository.findById(id).orElseThrow(
			() -> new IllegalArgumentException("존재하지 않는 카테고리입니다.")
		);

		log.info("Service - update : 시작");

		boardCategory.updateCategory(requestDto);

		log.info("Service - update : 끝");
	}

	// 카테고리 삭제
	public void deleteCategory(Long id) {
		BoardCategory boardCategory = boardCategoryRepository.findById(id).orElseThrow(
			() -> new IllegalArgumentException("존재하지 않는 카테고리입니다.")
		);

		log.info("Service - delete : 시작");

		boardCategoryRepository.delete(boardCategory);

		log.info("Service - delete : 끝");
	}


}
