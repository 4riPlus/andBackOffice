package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.response.PostListResponseDto;
import com.sparta.andbackoffice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class PostContoller {

    private final PostService postService;
    // 어드민 - 자유게시판 전체 조회
    @GetMapping("/posts")
    public ResponseEntity<PostListResponseDto> getPosts() {
        PostListResponseDto getPosts = postService.getPosts();
        return ResponseEntity.ok().body(getPosts);
    }
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        String message = postService.deletePost(id);
        return ResponseEntity.ok(message);
    }
}
