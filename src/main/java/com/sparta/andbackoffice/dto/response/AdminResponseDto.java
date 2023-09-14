package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.Admin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminResponseDto {
	private Long id;
	private Long companyNo;
	private String adminName;

	public AdminResponseDto(Admin admin) {
		this.id = admin.getId();
		this.companyNo = admin.getCompanyNo();
		this.adminName = admin.getAdminName();
	}
}
