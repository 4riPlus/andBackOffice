package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String userName);

	// 카카오 아이디 찾기
	Optional<User> findByKakaoId(Long kakaoId);

	// 구글 아이디 찾기
	Optional<User> findByGoogleId(String googleID);
}
