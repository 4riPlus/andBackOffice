package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.request.BoardRequestDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.BoardResponseDto;
import com.sparta.andbackoffice.security.UserDetailsImpl;
import com.sparta.andbackoffice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j(topic = "BoardController")
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

	//글 전체조회
	@GetMapping("/getAll")
	public ResponseEntity<List<BoardResponseDto>> getAllBoards() {
		List<BoardResponseDto> boards = boardService.getAllBoards();
		return ResponseEntity.ok(boards);
	}
}

