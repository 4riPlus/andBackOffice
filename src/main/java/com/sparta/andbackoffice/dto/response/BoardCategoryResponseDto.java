package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.BoardCategory;

import lombok.Getter;

@Getter
public class BoardCategoryResponseDto {
	private Long id;
	private String categoryName;

	public BoardCategoryResponseDto(BoardCategory category){
		this.id = category.getId();
		this.categoryName = category.getCategoryName();
	}

}
