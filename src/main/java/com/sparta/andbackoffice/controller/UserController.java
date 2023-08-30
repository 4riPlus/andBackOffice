package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 블랙리스트로 등록
    @PostMapping("/admin/userblackList/{id}")
    public ResponseEntity<UserBlackListResponseDto> registerUser(@PathVariable Long userId, @RequestBody UserBlackListRequestDto userBlackListRequestDto) {
        UserBlackListResponseDto registerUser = userService.registerUser(userId,userBlackListRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(registerUser);
    }
}
