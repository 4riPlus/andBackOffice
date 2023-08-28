package com.sparta.andbackoffice.entity;

import lombok.Getter;

@Getter
public enum DeleteStatus {
	Y("삭제 o"),
	N("삭제 x");

	private final String description;

	DeleteStatus(String description) {
		this.description = description;
	}
}
