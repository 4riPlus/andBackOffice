package com.sparta.andbackoffice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "reports")
@Entity
public class ReportPost extends TimeStamped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_post_id")
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "postId")
	private Post post;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@Column
	private String reportReason;

	public ReportPost(Post post, String reportReason, User writer) {
		this.post = post;
		this.user = writer;
		this.reportReason = reportReason;
	}
}