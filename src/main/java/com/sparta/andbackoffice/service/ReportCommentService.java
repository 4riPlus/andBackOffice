package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.response.ReportCommentCountResponseDto;
import com.sparta.andbackoffice.dto.response.ReportCommentResponseDto;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ReportCommentService {


	/**
	 * 신고 댓글 조회
	 */
	Page<ReportCommentResponseDto> getReportComments(int page, int size);

	List<ReportCommentCountResponseDto> getReportCommentCounts();
}
