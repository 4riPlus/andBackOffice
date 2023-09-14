package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.request.UserBlackListRequestDto;
import com.sparta.andbackoffice.dto.response.AdminListResponseDto;
import com.sparta.andbackoffice.dto.response.AdminResponseDto;
import com.sparta.andbackoffice.dto.response.BlackListResponseDto;
import com.sparta.andbackoffice.dto.response.UserBlackListResponseDto;
import com.sparta.andbackoffice.entity.User;
import com.sparta.andbackoffice.entity.UserBlackList;
import com.sparta.andbackoffice.repository.UserBlackListRepository;
import com.sparta.andbackoffice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
	private final UserBlackListRepository userBlackListRepository;
	private final UserRepository userRepository;

	//블랙리스트 전체 조회
	public BlackListResponseDto getBlacklist() {
		List<UserBlackListResponseDto> adminList = userBlackListRepository.findAll().stream()
				.map(UserBlackListResponseDto::new)
				.collect(Collectors.toList());
		return new BlackListResponseDto(adminList);
	}

	// 유저 블랙리스트로 등록
	public UserBlackListResponseDto registerUser(UserBlackListRequestDto userBlackListRequestDto) {
		String userName = userBlackListRequestDto.getUserName();

		// 유저 검색 및 블랙리스트에 등록하는 로직 추가
		User user = userRepository.findByUserName(userName)
				.orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));

		UserBlackList userBlacklist = new UserBlackList(user);
		userBlackListRepository.save(userBlacklist);
		userRepository.delete(user);

		return new UserBlackListResponseDto("블랙리스트에 등록이 완료되었습니다.");
	}
}