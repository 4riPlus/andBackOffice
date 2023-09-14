package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.request.UserBlackListRequestDto;
import com.sparta.andbackoffice.dto.response.UserBlackListResponseDto;
import com.sparta.andbackoffice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/blacklist")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    // 유저 블랙리스트로 등록
    @PostMapping("/register")
    public UserBlackListResponseDto registerUserToBlacklist(@RequestBody UserBlackListRequestDto requestDto) {
        String message = userService.registerUser(requestDto);
        return new UserBlackListResponseDto(message);
    }
}
