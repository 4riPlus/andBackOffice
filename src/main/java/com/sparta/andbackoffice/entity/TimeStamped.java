package com.sparta.andbackoffice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class TimeStamped {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@CreatedDate
	@Column(updatable = false) //최초 생성시간만 초기화 되고 그 뒤 수정될 수 없음
	private LocalDateTime createdDate;

	@LastModifiedDate //변경될 때마다 시간 저장
	@Column
	private LocalDateTime modifiedDate;

	public String getCreatedDateFormatted() {
		return createdDate.format(FORMATTER);
	}

	public String getModifiedDateFormatted() {
		return modifiedDate.format(FORMATTER);
	}
}

