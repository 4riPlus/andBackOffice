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
	public static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column(updatable = false)
	private LocalDateTime modifiedDate;


	public String getCreatedDateFormatted() {
		return createdDate.format(FORMATTER);
	}

	public String getModifiedDateFormatted() {
		return modifiedDate.format(FORMATTER);
	}

	public String getCreatedDateFormatted(DateTimeFormatter formatter) {
		return createdDate.format(formatter);
	}

	public String getModifiedDateFormatted(DateTimeFormatter formatter) {
		return modifiedDate.format(formatter);
	}
}

