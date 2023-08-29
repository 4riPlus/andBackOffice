package com.sparta.andbackoffice.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class BottomCategoryListResponseDto {
    private List<BottomCategoryResponseDto> bottomCategoryList;
    public BottomCategoryListResponseDto(List<BottomCategoryResponseDto>bottomCategoryList){
        this.bottomCategoryList = bottomCategoryList;
    }
}
