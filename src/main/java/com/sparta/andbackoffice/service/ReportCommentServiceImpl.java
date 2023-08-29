package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.response.ReportCommentCountResponseDto;
import com.sparta.andbackoffice.dto.response.ReportCommentResponseDto;
import com.sparta.andbackoffice.repository.ReportCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportCommentServiceImpl implements ReportCommentService {
	private final ReportCommentRepository reportCommentRepository;

	@Override
	public List<ReportCommentResponseDto> getReportComments() {
		return reportCommentRepository.findAll()
				.stream()
				.map(ReportCommentResponseDto::new)
				.toList();
	}

	@Override
	public List<ReportCommentCountResponseDto> getReportCommentCounts() {
		return reportCommentRepository.getReportCommentCount();
	}
}
