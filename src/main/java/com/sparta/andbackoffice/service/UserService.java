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


//@Slf4j
//@RequiredArgsConstructor
//@Service
//public class UserService {
//	private final UserBlackListRepository userBlackListRepository;
//	private final UserRepository userRepository;
//
//	// 유저 블랙리스트로 등록
//	public String  registerUser(UserBlackListRequestDto userBlackListRequestDto) {
//		String userName = userBlackListRequestDto.getUserName();
//		// 유저 검색 및 블랙리스트에 등록하는 로직 추가
//		User user = userRepository.findByUserName(userName)
//				.orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));
//
//		UserBlackList userBlacklist = new UserBlackList(user.getUserName());
//		userBlackListRepository.save(userBlacklist);
//		userRepository.delete(user);
//
//		return "User added to the blacklist successfully.";
//	}
//}