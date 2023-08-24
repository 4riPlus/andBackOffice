package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.CommentResponseDto;
import com.sparta.andbackoffice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponseDto> deleteComments(@PathVariable Long commentId) {
        return ResponseEntity.ok().body(commentService.deleteComment(commentId));
    }
}
