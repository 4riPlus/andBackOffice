package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.request.BoardRequestDto;
import com.sparta.andbackoffice.dto.request.ContestRequestDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.BoardResponseDto;
import com.sparta.andbackoffice.dto.response.ContestResponseDto;
import com.sparta.andbackoffice.service.ContestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j(topic = "ContestController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/contest")
public class ContestController {

	private final ContestService contestService;

	@PostMapping
	public ResponseEntity<?> createContest(@RequestBody ContestRequestDto requestDto) {
		log.info("Controller - createContest : 시작");

		ContestResponseDto result = contestService.createContest(requestDto);

		log.info("Controller - createContest : 끝");
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

		// 글 단건 조회
		@GetMapping("/{contestId}")
		public ResponseEntity<?> getContest(@PathVariable Long contestId) {
			log.info("Controller - getContest : 시작");

			ContestResponseDto result = contestService.getContest(contestId);

			log.info("Controller - getContest : 끝");
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}

		// 글 수정
		@PatchMapping("/{contestId}")
		public ResponseEntity<?> modifyContest(@PathVariable Long contestId,
		                                     @RequestBody ContestRequestDto requestDto) {
			log.info("Controller - modifyContest : 시작");

			ContestResponseDto result = contestService.modifyContest(contestId, requestDto);

			log.info("Controller - modifyContest : 끝");
			return ResponseEntity.status(HttpStatus.OK).body(result);

		}

		// 글 삭제
		@DeleteMapping("/{contestId}")
		public ResponseEntity<?> deleteContest(@PathVariable Long contestId) {
			log.info("Controller - deleteContest : 시작");

			ApiResponseDto result = contestService.deleteContest(contestId);

			log.info("Controller - deleteContest : 끝");
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
	}