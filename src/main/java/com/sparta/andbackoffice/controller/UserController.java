/*
package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.request.UserBlackListRequestDto;
import com.sparta.andbackoffice.dto.response.AdminListResponseDto;
import com.sparta.andbackoffice.dto.response.BlackListResponseDto;
import com.sparta.andbackoffice.dto.response.UserBlackListResponseDto;
import com.sparta.andbackoffice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/blacklist")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 블랙리스트 전체조회
    @GetMapping("/get")
    public ResponseEntity<BlackListResponseDto> getBlacklist() {
        BlackListResponseDto getBlacklist = userService.getBlacklist();
        return ResponseEntity.ok().body(getBlacklist);
    }

    // 유저 블랙리스트로 등록
    @PostMapping("/register")
    public ResponseEntity<UserBlackListResponseDto> registerUserToBlacklist(
            @RequestBody UserBlackListRequestDto userBlackListRequestDto) {
        UserBlackListResponseDto responseDto = userService.registerUser(userBlackListRequestDto);
        return ResponseEntity.ok().body(responseDto);
    }
}
*/
