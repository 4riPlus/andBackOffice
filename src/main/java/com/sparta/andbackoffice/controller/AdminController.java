package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.service.AdminService;
import dto.reponse.AdminListResponseDto;
import dto.reponse.AdminResponseDto;
import dto.reponse.ApiResponseDto;
import dto.request.AdminRequestDto;
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

        AdminResponseDto createAdmin = adminService.createAdmin(id,adminRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAdmin);
    }

    //관리자 수정
    @PutMapping("/admin/{id}")
    public ResponseEntity<ApiResponseDto> updateAdmin(@PathVariable Long id, @RequestBody AdminRequestDto adminRequestDto) {
        adminService.updateAdmin(id, adminRequestDto);
        return ResponseEntity.ok().body(new ApiResponseDto("관리자 수정완료", HttpStatus.OK.value()));
    }

    //관리자 삭제
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<ApiResponseDto> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok().body(new ApiResponseDto("관리자 삭제완료", HttpStatus.OK.value()));
    }
}
