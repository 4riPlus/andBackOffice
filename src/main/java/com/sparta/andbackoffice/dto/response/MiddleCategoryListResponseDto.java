package com.sparta.andbackoffice.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class MiddleCategoryListResponseDto {

    private List<MiddleCategoryResponseDto> middleCategoryList;
    public MiddleCategoryListResponseDto(List<MiddleCategoryResponseDto> middleCategoryList){
        this.middleCategoryList = middleCategoryList;
    }
}
