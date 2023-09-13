package com.sparta.andbackoffice.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.andbackoffice.entity.Admin;
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
