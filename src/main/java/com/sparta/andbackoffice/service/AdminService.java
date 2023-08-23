package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.entity.Admin;
import com.sparta.andbackoffice.repository.AdminRepository;
import dto.reponse.AdminListResponseDto;
import dto.reponse.AdminResponseDto;
import dto.request.AdminRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

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

        Admin result = new Admin(adminRequestDto.getCompanyNo(),adminRequestDto.getAdminName(),adminRequestDto.getAmdinPassword());
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
        admin.setAdminPassword(adminRequestDto.getAmdinPassword());

        return new AdminResponseDto(admin);
    }

    //관리자 삭제
    @Transactional
    public String deleteAdmin(Long id) {

        Admin admin = findById(id);
        if (admin.getId() != 1) {
            throw new IllegalArgumentException("접근권한이 없습니다.");
        }

        adminRepository.delete(admin);
        return "삭제완료";
    }

    private Admin findById(Long id) {
        return adminRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디를 찾을 수 없습니다.")
        );
    }
}
