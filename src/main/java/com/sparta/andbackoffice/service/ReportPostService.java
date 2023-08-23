package com.sparta.andbackoffice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sparta.andbackoffice.dto.response.ReportPostResponseDto;
import com.sparta.andbackoffice.entity.ReportPost;
import com.sparta.andbackoffice.repository.ReportPostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReportPostService {

	private final ReportPostRepository reportPostRepository;

	public List<ReportPostResponseDto> getReports () {
		List<ReportPost> reports = reportPostRepository.findAll();
		List<ReportPostResponseDto> postResponseDtoList =  new ArrayList<>();

		for (ReportPost reportPost : reports){
			postResponseDtoList.add(new ReportPostResponseDto(reportPost));
		}

		return postResponseDtoList;
	}

}
