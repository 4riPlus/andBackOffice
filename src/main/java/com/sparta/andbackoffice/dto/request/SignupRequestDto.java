package com.sparta.andbackoffice.dto.request;

import lombok.Getter;

@Getter
public class SignupRequestDto {
	private String adminName;
	private String adminPassword;
	private Long companyNo;
}
