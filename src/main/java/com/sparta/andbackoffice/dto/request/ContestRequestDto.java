package com.sparta.andbackoffice.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class ContestRequestDto {
	// 공모전 게시글의 카테고리는 1번으로 고정된 것을 상정함
	private String author;
	private String title;
	private String company;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDate endDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDate startDate;

	private String homepage;
	private String contents;
}
