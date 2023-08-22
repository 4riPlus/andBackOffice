package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.ApiResponseDto;
import com.sparta.andbackoffice.dto.request.BoardRequestDto;
import com.sparta.andbackoffice.dto.response.BoardResponseDto;
import com.sparta.andbackoffice.entity.Board;

public interface BoardService {

	/**
	 * 게시글 생성
	 *
	 * @param categoryId : 카테고리
	 * @param requestDto : 작성할 내용
	 * @return : 생성한 글 내용 반환
	 */
	BoardResponseDto createBoard(Long categoryId, BoardRequestDto requestDto);

	/**
	 * 게시글 단건 조회
	 *
	 * @param categoryId : 카테고리
	 * @param boardId    : 조회할 글 id
	 * @return : 게시글 정보 반환
	 */
	BoardResponseDto getBoard(Long categoryId, Long boardId);

	/**
	 * 게시글 수정
	 *
	 * @param categoryId : 카테고리
	 * @param boardId    : 수정할 게시글 id
	 * @param requestDto : 수정할 내용
	 * @return : 수정된 게시글 내용 반환
	 */
	BoardResponseDto modifyBoard(Long categoryId, Long boardId, BoardRequestDto requestDto);

	/**
	 * 게시글 삭제
	 *
	 * @param categoryId : 카테고리
	 * @param boardId    : 삭제할 게시글 id
	 * @return : 요청 처리 메시지 + 상태코드
	 */
	ApiResponseDto deleteBoard(Long categoryId, Long boardId);

	/**
	 * 존재하는 카테고리인지 검증
	 *
	 * @param categoryId : 검증할 카테고리 id
	 */
	void findCategory(Long categoryId);

	/**
	 * 존재하는 게시글인지 검증
	 *
	 * @param boardId : 검증할 게시글 id
	 * @return 존재하면 게시글 정보 반환
	 */
	Board findBoard(Long boardId);

	/**
	 * 해당 카테고리에 존재하는 글인지 / 글이 위치한 카테고리가 일치하는지 검증
	 *
	 * @param categoryId : 내가 입력한 카테고리
	 * @param board      : 게시글 정보 - 실제 글이 위치한 카테고리 id
	 */
	void equalsCategory(Long categoryId, Board board);
}
