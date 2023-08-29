package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.Contest;
import com.sparta.andbackoffice.entity.ContestStatus;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ContestResponseDto {
	private String author;
	private String title;
	private LocalDate endDate;
	private LocalDate startDate;
	private ContestStatus status;
	private String homepage;
	private Long contestViews;
	private String contents;

	public ContestResponseDto(Contest contest) {
		this.author = contest.getAuthor();
		this.title = contest.getTitle();
		this.endDate = contest.getEndDate();
		this.startDate = contest.getStartDate();
		this.status = contest.getStatus();
		this.homepage = contest.getHomepage();
		this.contestViews = contest.getContestViews();
		this.contents = contest.getContents();
	}
}
