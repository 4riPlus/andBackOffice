package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.Admin;
import com.sparta.andbackoffice.entity.User;
import com.sparta.andbackoffice.entity.UserBlackList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserBlackListResponseDto {
    private String message;

    public UserBlackListResponseDto(String message) {
        this.message = message;
    }
    public UserBlackListResponseDto(UserBlackList userBlackList) {
    }
}