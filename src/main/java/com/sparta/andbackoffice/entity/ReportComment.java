package com.sparta.andbackoffice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "report_comments")
public class ReportComment extends TimeStamped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_comment_id")
	private Long id;

	@Column
	@Lob
	private String reportReason;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "comment_id")
	private Comment comment;

	@Builder
	public ReportComment(String reportReason, Comment comment, User reporter) {
		this.reportReason = reportReason;
		this.comment = comment;
		this.user = reporter;
	}
}

