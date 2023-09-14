package com.sparta.andbackoffice.controller;


import com.sparta.andbackoffice.dto.request.AdminRequestDto;
import com.sparta.andbackoffice.dto.request.LoginRequestDto;
import com.sparta.andbackoffice.dto.request.SignupRequestDto;
import com.sparta.andbackoffice.dto.response.AdminListResponseDto;
import com.sparta.andbackoffice.dto.response.AdminResponseDto;
import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.jwt.JwtUtil;
import com.sparta.andbackoffice.security.UserDetailsImpl;
import com.sparta.andbackoffice.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

	private final AdminService adminService;
	private final JwtUtil jwtUtil;

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody SignupRequestDto requestDto) {
		return adminService.signup(requestDto);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDto requestDto, HttpServletResponse response) {
		try {
			adminService.login(requestDto);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new ApiResponseDto("회원을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST.value()));
		}

		response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(requestDto.getAdminName()));

		return ResponseEntity.ok().body(new ApiResponseDto("로그인 성공", HttpStatus.CREATED.value()));
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logout(@AuthenticationPrincipal UserDetailsImpl userDetails, HttpServletRequest request) {
		return ResponseEntity.ok().body(new ApiResponseDto(adminService.logout(request, userDetails.getUser()), HttpStatus.OK.value()));
	}

	//관리자 조회
	@GetMapping("/get")
	public ResponseEntity<AdminListResponseDto> getAdmin() {
		AdminListResponseDto getAdmin = adminService.getAdmin();
		return ResponseEntity.ok().body(getAdmin);
	}

	@PostMapping("/create")
	public ResponseEntity<AdminResponseDto> createAdmin(@RequestBody AdminRequestDto adminRequestDto) {
		AdminResponseDto createAdmin = adminService.createAdmin(adminRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAdmin);
	}

	//관리자 삭제
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
		String msg = adminService.deleteAdmin(id);
		return ResponseEntity.ok(msg);
	}
}