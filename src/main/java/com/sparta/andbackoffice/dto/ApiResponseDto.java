package com.sparta.andbackoffice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponseDto {
	private String msg;
	private Integer status;
}
