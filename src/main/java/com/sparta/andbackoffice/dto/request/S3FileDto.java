package com.sparta.andbackoffice.dto.request;

import com.sparta.andbackoffice.entity.S3File;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class S3FileDto {

	private Long S3FileId;
	private String originalFileName;
	private String uploadFileName;
	private String uploadFilePath;
	private String uploadFileUrl;

	@Builder
	public S3FileDto(Long s3FileId, String originalFileName, String uploadFileName, String uploadFilePath, String uploadFileUrl) {
		this.S3FileId = s3FileId;
		this.originalFileName = originalFileName;
		this.uploadFileName = uploadFileName;
		this.uploadFilePath = uploadFilePath;
		this.uploadFileUrl = uploadFileUrl;
	}

	public S3FileDto(S3File s3File) {
		this.S3FileId = s3File.getId();
		this.originalFileName = s3File.getOriginalFileName();
		this.uploadFileName = s3File.getUploadFileName();
		this.uploadFilePath = s3File.getUploadFilePath();
		this.uploadFileUrl = s3File.getUploadFileUrl();
	}
}
