package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.service.Amazon3SService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/file")
public class AmazonS3Controller {

	private final Amazon3SService amazon3SService;

	@PostMapping("/uploads")
	public ResponseEntity<Object> uploadFiles(
			@RequestParam(value = "fileType") String fileType,
			@RequestPart(value = "files") List<MultipartFile> multipartFiles) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(amazon3SService.uploadFiles(fileType, multipartFiles));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Object> deleteFile(
			@RequestParam(value = "uploadFilePath") String uploadFilePath,
			@RequestParam(value = "uuidFileName") String uuidFileName) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(amazon3SService.deleteFile(uploadFilePath, uuidFileName));
	}
}

