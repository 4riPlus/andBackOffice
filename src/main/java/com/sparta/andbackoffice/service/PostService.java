package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.response.PostListResponseDto;
import com.sparta.andbackoffice.dto.response.PostResponseDto;
import com.sparta.andbackoffice.entity.Post;
import com.sparta.andbackoffice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
    //게시글 삭제 API
    @Transactional
    public String deletePost(Long id) {
        Post post = PostRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."));

        PostRepository.delete(post);

        return "게시글이 성공적으로 삭제되었습니다.";
    }

}
