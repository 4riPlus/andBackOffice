package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.response.CommentResponseDto;
import com.sparta.andbackoffice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{postId}")
    //public ResponseEntity<ApiResponseDto> getComments(@AuthenticationPrincipal UserDetailsImpl userDetails) {
    public ResponseEntity<List<CommentResponseDto>> getComments(@PathVariable Long postId) {
        return ResponseEntity.ok().body(commentService.getComments(postId));
    }
}
