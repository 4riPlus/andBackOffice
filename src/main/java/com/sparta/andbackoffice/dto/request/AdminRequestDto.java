package com.sparta.andbackoffice.dto.request;

import com.sparta.andbackoffice.entity.Admin;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminRequestDto {
    private Long companyNo;
    private String adminName;
    private String amdinPassword;

    public AdminRequestDto(Admin admin) {
        this.companyNo = admin.getCompanyNo();
        this.adminName = admin.getAdminName();
        this.amdinPassword = admin.getAdminPassword();
    }
}
