package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.response.ReportCommentCountResponseDto;
import com.sparta.andbackoffice.dto.response.ReportCommentResponseDto;
import com.sparta.andbackoffice.entity.ReportComment;
import com.sparta.andbackoffice.repository.ReportCommentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportCommentServiceImpl implements ReportCommentService {
	private final ReportCommentRepository reportCommentRepository;

	@Transactional
	@Override
	public Page<ReportCommentResponseDto> getReportComments(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		Page<ReportComment> comments = reportCommentRepository.findAll(pageable);
		return comments.map(ReportCommentResponseDto :: new);
	}
	// public List<ReportCommentResponseDto> getReportComments() {
	// 	return reportCommentRepository.findAll()
	// 			.stream()
	// 			.map(ReportCommentResponseDto::new)
	// 			.toList();
	// }

	@Override
	public List<ReportCommentCountResponseDto> getReportCommentCounts() {
		return reportCommentRepository.getReportCommentCount();
	}
}
