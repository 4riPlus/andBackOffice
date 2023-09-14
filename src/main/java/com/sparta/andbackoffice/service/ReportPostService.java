package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.ReportPostResponseDto;
import com.sparta.andbackoffice.entity.Post;
import com.sparta.andbackoffice.entity.ReportPost;
import com.sparta.andbackoffice.repository.CommentRepository;
import com.sparta.andbackoffice.repository.PostRepository;
import com.sparta.andbackoffice.repository.ReportPostRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReportPostService {

	private final ReportPostRepository reportPostRepository;
	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	@Transactional
	public Page<ReportPostResponseDto> getReports(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<ReportPost> posts = reportPostRepository.findAll(pageable);
		return  posts.map(ReportPostResponseDto::new);
	}

	@Transactional
	public ResponseEntity<ApiResponseDto> deleteReport(Long id) {
		// 신고된 게시글이 존재하는지 확인
		ReportPost checkReport = reportPostRepository.findByPostId(id).orElse(null);

		if (checkReport == null) {
			log.error("신고된 게시글이 존재하지 않습니다.");
			return ResponseEntity.status(400)
				.body(new ApiResponseDto("신고된 게시글이 존재하지 않습니다.", HttpStatus.BAD_REQUEST.value()));
		}

		Post checkPost = postRepository.findById(id).orElse(null);
		if (checkPost == null) {
			log.error("게시글이 존재하지 않습니다.");
			return ResponseEntity.status(400)
				.body(new ApiResponseDto("게시글이 존재하지 않습니다.", HttpStatus.BAD_REQUEST.value()));
		} else {
			// Delete associated ReportPosts first
			reportPostRepository.deleteByPost(checkPost);

			commentRepository.deleteByPostId(id);

			// Then delete the Post
			postRepository.delete(checkPost);
			return ResponseEntity.status(200).body(new ApiResponseDto("해당 게시글이 삭제되었습니다.", HttpStatus.OK.value()));
		}
	}

}
