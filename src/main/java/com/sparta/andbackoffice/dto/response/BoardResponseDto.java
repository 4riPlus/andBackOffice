package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.Board;

import lombok.Getter;

@Getter
public class BoardResponseDto {
	private Long id;
	private String categoryName;
	private String title;
	private String contents;

	public BoardResponseDto(Board board) {
		this.id= board.getId();
		this.title = board.getTitle();
		this.categoryName = board.getCategory().getCategoryName();
		this.contents = board.getContents();
	}
}
