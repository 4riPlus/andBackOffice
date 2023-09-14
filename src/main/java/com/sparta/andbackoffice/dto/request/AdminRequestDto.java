package com.sparta.andbackoffice.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AdminRequestDto {
	private Long id;
	private Long companyNo;
	private String adminName;
	private String adminPassword;

}
