package com.sparta.andbackoffice.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.ReportPostResponseDto;
import com.sparta.andbackoffice.service.ReportPostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/admin/reports")
@RestController
public class ReportPostController {

	private final ReportPostService reportPostService;

	@GetMapping("")
	public ResponseEntity<Page<ReportPostResponseDto>> getReports (
		@RequestParam("page") int page,
		@RequestParam("size") int size){
		return ResponseEntity.ok().body(reportPostService.getReports(page-1,size));
	}


	@DeleteMapping("/{postId}")
	public ResponseEntity<ApiResponseDto> deleteReports (@PathVariable Long postId){
		return reportPostService.deleteReport(postId);
	}
}
