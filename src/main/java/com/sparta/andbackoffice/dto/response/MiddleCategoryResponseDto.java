package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.MiddleCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MiddleCategoryResponseDto {
    private Long id;
    private String categoryName;

    public MiddleCategoryResponseDto(MiddleCategory middleCategory) {
        this.id = middleCategory.getMiddleCategoryId();
        this.categoryName = middleCategory.getCategoryName();
    }
}
