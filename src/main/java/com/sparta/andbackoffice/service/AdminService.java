package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.request.AdminRequestDto;
import com.sparta.andbackoffice.dto.request.LoginRequestDto;
import com.sparta.andbackoffice.dto.request.SignupRequestDto;
import com.sparta.andbackoffice.dto.response.AdminListResponseDto;
import com.sparta.andbackoffice.dto.response.AdminResponseDto;
import com.sparta.andbackoffice.entity.Admin;
import com.sparta.andbackoffice.jwt.JwtUtil;
import com.sparta.andbackoffice.repository.AdminRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {
	private final AdminRepository adminRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	private final RedisTemplate<String, String> redisTemplate;

	public ResponseEntity<Objects> signup(SignupRequestDto requestDto) {
		String userId = requestDto.getAdminName();
		String password = passwordEncoder.encode(requestDto.getAdminPassword());
		Long number = requestDto.getCompanyNo();

		Admin admin = new Admin(number, userId, password);
		adminRepository.save(admin);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	public void login(LoginRequestDto requestDto) {
		String name = requestDto.getAdminName();
		String password = requestDto.getAdminPassword();

		Admin admin = adminRepository.findByAdminName(name).orElseThrow(
				() -> new IllegalArgumentException("회원을 찾을 수 없습니다.")
		);
		log.info("네임 검증");

		if (!passwordEncoder.matches(password, admin.getAdminPassword())) {
			log.info("비밀번호 검증");
			throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
		}
		log.info("비밀번호 정상");
	}

	public String logout(HttpServletRequest request, Admin admin) {

		String accessToken = jwtUtil.getJwtFromHeader(request);

		if (!jwtUtil.validateToken(accessToken)) {
			throw new IllegalArgumentException("유효하지 않은 토큰입니다");
		}

		if (redisTemplate.opsForValue().get("RT:" + admin.getAdminName()) != null) {
			redisTemplate.delete("RT:" + admin.getAdminName());
		}
		Claims info = jwtUtil.getUserInfoFromToken(accessToken);
		Long expiration = info.getExpiration().getTime();
		redisTemplate.opsForValue().set(accessToken, "logout", expiration, TimeUnit.MICROSECONDS);
		return "로그아웃 성공";
	}

	//관리자 전체조회
	public AdminListResponseDto getAdmin() {
		List<AdminResponseDto> adminList = adminRepository.findAll().stream()
				.map(AdminResponseDto::new)
				.collect(Collectors.toList());
		return new AdminListResponseDto(adminList);
	}

	//관리자 생성
	public AdminResponseDto createAdmin(Long id, AdminRequestDto adminRequestDto) {

		Admin admin = findById(id);

		if (admin.getId() != 1) {
			throw new IllegalArgumentException("접근권한이 없습니다.");
		}

		Admin result = new Admin(adminRequestDto.getCompanyNo(), adminRequestDto.getAdminName(), adminRequestDto.getAdminPassword());
		return new AdminResponseDto(adminRepository.save(result));
	}

	//관리자 수정
	@Transactional
	public AdminResponseDto updateAdmin(Long id, AdminRequestDto adminRequestDto) {

		Admin admin = findById(id);

		if (admin.getId() != 1) {
			throw new IllegalArgumentException("접근권한이 없습니다.");
		}

		admin.setAdminName(adminRequestDto.getAdminName());
		admin.setAdminPassword(adminRequestDto.getAdminPassword());

		return new AdminResponseDto(admin);
	}

	//관리자 삭제
	@Transactional
	public AdminResponseDto deleteAdmin(Long id) {

		Admin admin = findById(id);
		if (admin.getId() != 1) {
			throw new IllegalArgumentException("접근권한이 없습니다.");
		}

		adminRepository.delete(admin);
		return new AdminResponseDto(admin);
	}

	private Admin findById(Long id) {
		return adminRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("해당 아이디를 찾을 수 없습니다.")
		);
	}
}
