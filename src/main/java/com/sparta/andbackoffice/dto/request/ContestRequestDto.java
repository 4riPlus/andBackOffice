package com.sparta.andbackoffice.dto.request;

import lombok.Getter;

@Getter
public class ContestRequestDto {
	// 공모전 게시글의 카테고리는 고정된 것으로 상정함
	private String author;
	private String title;
	private String company;
	private String deadline;
	private String homepage;
	private String contents;
}
