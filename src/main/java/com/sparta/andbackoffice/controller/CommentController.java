package com.sparta.andbackoffice.controller;

import com.sparta.andbackoffice.dto.response.CommentResponseDto;
import com.sparta.andbackoffice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/admin/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{postId}")
    //public ResponseEntity<ApiResponseDto> getComments(@AuthenticationPrincipal UserDetailsImpl userDetails) {
    public List<CommentResponseDto> getComments(@PathVariable Long postId) {
        return commentService.getComments(postId);
    }
}
