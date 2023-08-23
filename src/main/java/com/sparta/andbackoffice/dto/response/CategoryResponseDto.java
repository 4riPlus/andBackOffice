package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryResponseDto {
	private Long id;
	private String categoryName;

	public CategoryResponseDto(Category category) {
		this.id = category.getId();
		this.categoryName = category.getCategoryName();
	}
}
