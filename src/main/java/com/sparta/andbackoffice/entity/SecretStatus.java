package com.sparta.andbackoffice.entity;

import lombok.Getter;

@Getter
public enum SecretStatus {
	Y("비밀댓글 o"),
	N("비밀댓글 x");

	private final String description;

	SecretStatus(String description) {
		this.description = description;
	}
}
