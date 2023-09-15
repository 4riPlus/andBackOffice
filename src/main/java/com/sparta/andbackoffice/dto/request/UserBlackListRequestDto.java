package com.sparta.andbackoffice.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserBlackListRequestDto {
    private String userName;

    public UserBlackListRequestDto(String userName) {
        this.userName = userName;
    }
}
