package com.sparta.andbackoffice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparta.andbackoffice.dto.request.BoardRequestDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.BoardResponseDto;
import com.sparta.andbackoffice.entity.Board;
import com.sparta.andbackoffice.entity.MiddleCategory;
import com.sparta.andbackoffice.repository.BoardRepository;
import com.sparta.andbackoffice.repository.CategoryRepository;
import com.sparta.andbackoffice.repository.MiddleCategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j(topic = "BoardService")
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	private final CategoryRepository categoryRepository;
	private final MiddleCategoryRepository middleCategoryRepository;

	@Override
	public List<BoardResponseDto> getAllBoards() {
		List<Board> boards = boardRepository.findAll();
		return boards.stream().map(BoardResponseDto::new).collect(Collectors.toList());
	}

	@Override
	public BoardResponseDto createBoard(MiddleCategory categoryId, BoardRequestDto requestDto) {
		log.info("Service - createBoard : 시작");

		findCategory(categoryId);
		Board board = boardRepository.save(new Board(categoryId, requestDto));

		log.info("Service - createBoard : 끝");
		return new BoardResponseDto(board);
	}


	@Override
	@Transactional
	public BoardResponseDto modifyBoard(Long id, BoardRequestDto requestDto) {
		log.info("Service - modifyBoard : 시작");

		Board board = findById(id);
		board.setTitle(requestDto.getTitle());
		board.setContents(requestDto.getContents());

		log.info("Service - modifyBoard : 끝");
		return new BoardResponseDto(board);
	}

	private Board findById(Long id) {
		return boardRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다.")
		);
	}

	@Override
	@Transactional
	public ApiResponseDto deleteBoard(Long id) {
		log.info("Service - deleteBoard : 시작");

		Board board = findById(id);
		boardRepository.delete(board);

		log.info("Service - deleteBoard : 끝");
		return new ApiResponseDto("게시글 삭제 완료", HttpStatus.OK.value());
	}

	@Override
	public void findCategory(MiddleCategory categoryId) {
		middleCategoryRepository.findById(categoryId.getMiddleCategoryId()).orElseThrow(
				() -> new IllegalArgumentException("존재하지 않는 카테고리입니다.")
		);
	}


	@Override
	public Board findBoard(Long boardId) {
		return boardRepository.findById(boardId).orElseThrow(
			() -> new IllegalArgumentException("존재하지 않는 글입니다.")
		);
	}


	@Override
	public void equalsCategory(MiddleCategory categoryId, Board board) {
		if (!(board.getCategoryId().equals(categoryId))) {
			throw new IllegalArgumentException("카테고리가 일치하는지 다시 확인해주세요.");
		}
	}
}
