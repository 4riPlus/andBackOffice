package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.dto.response.ReportCommentCountResponseDto;

import java.util.List;

public interface ReportCommentRepositoryQuery {
    List<ReportCommentCountResponseDto> getReportCommentCount();
}
