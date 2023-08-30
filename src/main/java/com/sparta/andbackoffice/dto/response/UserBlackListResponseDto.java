package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.UserBlackList;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UserBlackListResponseDto {
    private Long blackListId;

    public UserBlackListResponseDto(UserBlackList userBlackList) {
        this.blackListId = userBlackList.getBlackListId();
    }
}
