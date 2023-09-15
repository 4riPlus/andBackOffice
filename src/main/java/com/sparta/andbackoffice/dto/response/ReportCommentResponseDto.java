package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.ReportComment;
import lombok.Getter;

@Getter
public class ReportCommentResponseDto {
	private Long reportCommentId;
	private Long commentId;
	private String comment;
	private String writer;
	private String reporter;
	private String reportReason;
	private String createdDate;

	public ReportCommentResponseDto(ReportComment reportComment) {
		this.reportCommentId = reportComment.getId();
		this.commentId = reportComment.getComment().getId();
		this.comment = reportComment.getComment().getContent();
		this.writer = reportComment.getComment().getWriter().getNickname();
		this.reporter = reportComment.getUser().getNickname();
		this.reportReason = reportComment.getReportReason();
		this.createdDate = reportComment.getCreatedDateFormatted();
	}
}
