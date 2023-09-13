package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.response.ReportCommentCountResponseDto;
import com.sparta.andbackoffice.dto.response.ReportCommentResponseDto;
import com.sparta.andbackoffice.service.ReportCommentService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/reportComments")
public class ReportCommentController {
	private final ReportCommentService reportCommentService;

	@GetMapping
	public ResponseEntity<Page<ReportCommentResponseDto>> getReportComments(
		@RequestParam("page") int page,
		@RequestParam("size") int size) {
		return ResponseEntity.ok().body(reportCommentService.getReportComments(page-1,size));
	}

	@GetMapping("/counts")
	public ResponseEntity<List<ReportCommentCountResponseDto>> getReportCommentCounts() {
		return ResponseEntity.ok().body(reportCommentService.getReportCommentCounts());
	}
}
