package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.CommentResponseDto;
import com.sparta.andbackoffice.entity.Comment;

import java.util.List;

public interface CommentService {

	/**
	 * 댓글 전체 조회 (댓글 원본 표시)
	 *
	 * @param postId 게시글 id
	 * @return 게시글의 전체 댓글 리스트
	 */
	List<CommentResponseDto> getComments(Long postId);

	/**
	 * 댓글 삭제
	 *
	 * @param commentId 삭제할 댓글 ID
	 * @return 요청 결과
	 */
	ApiResponseDto deleteComment(Long commentId);

	/**
	 * 댓글 조회
	 *
	 * @param commentId 조회할 댓글 ID
	 * @return Comment or IllegalException
	 */
	Comment getCommentById(Long commentId);
}
