package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.request.BoardRequestDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.BoardResponseDto;
import com.sparta.andbackoffice.entity.Admin;
import com.sparta.andbackoffice.entity.Board;
import com.sparta.andbackoffice.entity.Category;
import com.sparta.andbackoffice.repository.AdminRepository;
import com.sparta.andbackoffice.repository.BoardRepository;
import com.sparta.andbackoffice.repository.CategoryRepository;
import com.sparta.andbackoffice.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j(topic = "BoardService")
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	private final CategoryRepository categoryRepository;
	private final AdminRepository adminRepository;

	@Override
	public BoardResponseDto createBoard(Long categoryId, BoardRequestDto requestDto, UserDetailsImpl userDetails) {
		log.info("Service - createBoard : 시작");

		checkAdmin(userDetails);
		findCategory(categoryId);
		Board board = boardRepository.save(new Board(categoryId, requestDto));

		log.info("Service - createBoard : 끝");
		return new BoardResponseDto(board);
	}

	@Override
	public BoardResponseDto getBoard(Long categoryId, Long boardId, UserDetailsImpl userDetails) {
		log.info("Service - getBoard : 시작");

		checkAdmin(userDetails);
		findCategory(categoryId);
		Board board = findBoard(boardId);
		equalsCategory(categoryId, board);

		log.info("Service - getBoard : 끝");
		return new BoardResponseDto(board);
	}

	@Override
	@Transactional
	public BoardResponseDto modifyBoard(Long categoryId, Long boardId, BoardRequestDto requestDto, UserDetailsImpl userDetails) {
		log.info("Service - modifyBoard : 시작");

		checkAdmin(userDetails);
		findCategory(categoryId);
		Board board = findBoard(boardId);
		equalsCategory(categoryId, board);

		if (!(requestDto.getCategory() == null)) {
			board.setCategory(requestDto.getCategory());
		}
		board.setTitle(requestDto.getTitle());
		board.setContents(requestDto.getContents());

		log.info("Service - modifyBoard : 끝");
		return new BoardResponseDto(board);
	}

	@Override
	@Transactional
	public ApiResponseDto deleteBoard(Long categoryId, Long boardId, UserDetailsImpl userDetails) {
		log.info("Service - deleteBoard : 시작");

		checkAdmin(userDetails);
		findCategory(categoryId);
		Board board = findBoard(boardId);
		equalsCategory(categoryId, board);
		boardRepository.delete(board);

		log.info("Service - deleteBoard : 끝");
		return new ApiResponseDto("게시글 삭제 완료", HttpStatus.OK.value());
	}

	@Override
	public void checkAdmin(UserDetailsImpl userDetails) {
		Admin admin = adminRepository.findByAdminName(userDetails.getUser().getAdminName())
				.orElseThrow(
						() -> new IllegalArgumentException("권한이 없습니다.")
				);
	}

	@Override
	public void findCategory(Long categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(
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
	public void equalsCategory(Long categoryId, Board board) {
		if (!(board.getCategory().equals(categoryId))) {
			throw new IllegalArgumentException("카테고리가 일치하는지 다시 확인해주세요.");
		}
	}
}
