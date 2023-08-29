package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.ReportPost;

import lombok.Getter;

@Getter
public class ReportPostResponseDto {

	private Long id;
	private String reportReason;

	public ReportPostResponseDto(ReportPost reportPost) {
		this.id = reportPost.getId();
		this.reportReason = reportPost.getReportReason();
	}

}
