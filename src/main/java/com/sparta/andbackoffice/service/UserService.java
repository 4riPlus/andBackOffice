package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.request.UserBlackListRequestDto;
import com.sparta.andbackoffice.dto.response.UserBlackListResponseDto;
import com.sparta.andbackoffice.entity.User;
import com.sparta.andbackoffice.entity.UserBlackList;
import com.sparta.andbackoffice.repository.UserBlackListRepository;
import com.sparta.andbackoffice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserBlackListRepository userBlackListRepository;
    private final UserRepository userRepository;

    // 유저 블랙리스트로 등록
    public UserBlackListResponseDto registerUser(Long userId, UserBlackListRequestDto userBlackListRequestDto) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));

        UserBlackList userBlackList = new UserBlackList(userBlackListRequestDto.getUserId());

        userBlackListRepository.save(userBlackList);
        userRepository.delete(user);
        return new UserBlackListResponseDto();
    }
}