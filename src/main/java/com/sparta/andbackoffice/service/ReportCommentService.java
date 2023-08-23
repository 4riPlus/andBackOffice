package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.response.ReportCommentCountResponseDto;
import com.sparta.andbackoffice.dto.response.ReportCommentResponseDto;

import java.util.List;

public interface ReportCommentService {


    /**
     * 신고 댓글 조회
     */
    List<ReportCommentResponseDto> getReportComments();

    List<ReportCommentCountResponseDto> getReportCommentCounts();
}
