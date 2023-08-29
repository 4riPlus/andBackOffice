package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
	private Long category;
	private String title;
	private String contents;

	public BoardResponseDto(Board board) {
		this.category = board.getCategory();
		this.title = board.getTitle();
		this.contents = board.getContents();
	}
}
