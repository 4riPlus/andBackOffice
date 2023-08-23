package com.sparta.andbackoffice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.andbackoffice.dto.response.ReportPostResponseDto;
import com.sparta.andbackoffice.service.ReportPostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/admin/reports")
@RestController
public class ReportPostController {

	private final ReportPostService reportPostService;

	@GetMapping("")
	public List<ReportPostResponseDto> getReports (){
		return reportPostService.getReports();
	}
}
