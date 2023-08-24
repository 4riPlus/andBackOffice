package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.request.AdminRequestDto;
import com.sparta.andbackoffice.dto.response.AdminListResponseDto;
import com.sparta.andbackoffice.dto.response.AdminResponseDto;
import com.sparta.andbackoffice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminController {

	private final AdminService adminService;

	//관리자 조회
	@GetMapping("/admin")
	public ResponseEntity<AdminListResponseDto> getAdmin() {
		AdminListResponseDto getAdmin = adminService.getAdmin();
		return ResponseEntity.ok().body(getAdmin);
	}

	//관리자 생성
	@PostMapping("/admin")
	public ResponseEntity<AdminResponseDto> createAdmin(@PathVariable Long id, @RequestBody AdminRequestDto adminRequestDto) {

		AdminResponseDto createAdmin = adminService.createAdmin(id, adminRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAdmin);
	}

	//관리자 수정
	@PutMapping("/admin/{id}")
	public ResponseEntity<AdminResponseDto> updateAdmin(@PathVariable Long id, @RequestBody AdminRequestDto adminRequestDto) {
		AdminResponseDto updateAdmin = adminService.updateAdmin(id, adminRequestDto);
		return ResponseEntity.ok().body(updateAdmin);
	}

	//관리자 삭제
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<AdminResponseDto> deleteAdmin(@PathVariable Long id) {
		AdminResponseDto deleteAdmin = adminService.deleteAdmin(id);
		return ResponseEntity.ok().body(deleteAdmin);
	}
}
