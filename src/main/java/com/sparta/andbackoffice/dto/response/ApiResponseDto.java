package com.sparta.andbackoffice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto {
	private Integer status;
	private String message;
	private Object data;


	public ApiResponseDto(String message, int status) {
		this.status = status;
		this.message = message;
		this.data = null;
	}

	public ApiResponseDto(int status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
}


