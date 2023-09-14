package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.BottomCategory;
import com.sparta.andbackoffice.entity.MiddleCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class MiddleCategoryDetailsDto {
    private Long middleCategoryId;
    private  String categoryName;
    private List<BottomCategory> bottomCategories;

    public  MiddleCategoryDetailsDto(MiddleCategory middleCategory) {
        this.middleCategoryId = middleCategory.getMiddleCategoryId();
        this.categoryName = middleCategory.getCategoryName();
        this.bottomCategories = middleCategory.getBottomCategories();

    }
}
