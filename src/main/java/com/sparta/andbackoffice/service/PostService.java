package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.response.PostListResponseDto;
import com.sparta.andbackoffice.dto.response.PostResponseDto;
import com.sparta.andbackoffice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
	private final PostRepository PostRepository;

	// 어드민 - 자유게시판 전체 조회
	public PostListResponseDto getPosts() {
		List<PostResponseDto> postList = PostRepository.findAll().stream()
				.map(PostResponseDto::new)
				.collect(Collectors.toList());

		return new PostListResponseDto(postList);
	}
}
