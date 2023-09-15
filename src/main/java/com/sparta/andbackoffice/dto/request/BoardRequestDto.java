package com.sparta.andbackoffice.dto.request;

import com.sparta.andbackoffice.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequestDto {
	/**
	 * 글 작성할 때 Body에 카테고리 적을 필요 x
	 * => URL에 있는 categoryId 기준으로 생성됨
	 * 카테고리를 이동하고 싶은 경우에만 Body에 category 작성
	 */
	private Long categoryId;
	private String title;
	private String contents;
}
