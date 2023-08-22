package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.ApiResponseDto;
import com.sparta.andbackoffice.dto.request.BoardRequestDto;
import com.sparta.andbackoffice.dto.BoardResponseDto;
import com.sparta.andbackoffice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/posts")
public class BoardController {

	private final BoardService boardService;

	// 글 작성
	@PostMapping("/{categoryId}")
	public ResponseEntity<?> createBoard(@PathVariable Long categoryId,
	                                     @RequestBody BoardRequestDto requestDto) {
		log.info("Controller - createBoard : 시작");

		BoardResponseDto result = boardService.createBoard(categoryId, requestDto);

		log.info("Controller - createBoard : 끝");
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	// 글 단건 조회
	@GetMapping("/{categoryId}/{boardId}")
	public ResponseEntity<?> getBoard(@PathVariable Long categoryId,
	                                  @PathVariable Long boardId) {
		log.info("Controller - getBoard : 시작");

		BoardResponseDto result = boardService.getBoard(categoryId, boardId);

		log.info("Controller - getBoard : 끝");
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	// 글 수정
	@PatchMapping("/{categoryId}/{boardId}")
	public ResponseEntity<?> modifyBoard(@PathVariable Long categoryId,
	                                     @PathVariable Long boardId,
	                                     @RequestBody BoardRequestDto requestDto) {
		log.info("Controller - modifyBoard : 시작");

		BoardResponseDto result = boardService.modifyBoard(categoryId, boardId, requestDto);

		log.info("Controller - modifyBoard : 끝");
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	// 글 삭제
	@DeleteMapping("/{categoryId}/{boardId}")
	public ResponseEntity<?> deleteBoard(@PathVariable Long categoryId,
	                                     @PathVariable Long boardId) {
		log.info("Controller - deleteBoard : 시작");

		ApiResponseDto result = boardService.deleteBoard(categoryId, boardId);

		log.info("Controller - deleteBoard : 끝");
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}

