package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.ReportPost;
import com.sparta.andbackoffice.entity.User;

import lombok.Getter;

@Getter
public class ReportPostResponseDto {

	private Long id;
	private Long postId;
	private String title;
	private String contents;
	private String writer;
	private String reporter;
	private String reportReason;
	private String createdDate;

	public ReportPostResponseDto(ReportPost reportPost) {
		this.id = reportPost.getId();
		this.postId = reportPost.getPost().getId();
		this.title = reportPost.getPost().getTitle();
		this.contents = reportPost.getPost().getContents();
		this.writer = reportPost.getPost().getUser().getNickname();
		this.reporter = reportPost.getUser().getNickname();
		this.reportReason = reportPost.getReportReason();
		this.createdDate = reportPost.getCreatedDateFormatted();
	}

}
