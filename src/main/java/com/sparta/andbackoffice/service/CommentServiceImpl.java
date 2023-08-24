package com.sparta.andbackoffice.service;

import com.sparta.andbackoffice.dto.response.ApiResponseDto;
import com.sparta.andbackoffice.dto.response.CommentResponseDto;
import com.sparta.andbackoffice.dto.response.ReportCommentResponseDto;
import com.sparta.andbackoffice.entity.Comment;
import com.sparta.andbackoffice.entity.DeleteStatus;
import com.sparta.andbackoffice.entity.Post;
import com.sparta.andbackoffice.entity.ReportComment;
import com.sparta.andbackoffice.repository.CommentRepository;
import com.sparta.andbackoffice.repository.PostRepository;
import com.sparta.andbackoffice.repository.ReportCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public List<CommentResponseDto> getComments(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        List<Comment> comments = commentRepository.getCommentListFindByPostId(postId)
                .stream()
                .toList();

        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
        Map<Long, CommentResponseDto> commentResponseDtoHashMap = new HashMap<>();

        comments.forEach(c -> {
            CommentResponseDto commentResponseDto = new CommentResponseDto(c);

            convertComment(commentResponseDto, c.getIsDeleted());

            commentResponseDtoHashMap.put(commentResponseDto.getCommentId(), commentResponseDto);
            if(c.getParent() != null) commentResponseDtoHashMap.get(c.getParent().getId()).getChild().add(commentResponseDto);
            else commentResponseDtoList.add(commentResponseDto);
        });
        return commentResponseDtoList;
    }

    @Transactional
    @Override
    public ApiResponseDto deleteComment(Long commentId) {
        Comment comment = getCommentById(commentId);

        if(comment.getChildren().size() != 0) {
            comment.setIsDeleted(DeleteStatus.Y);
        } else {
            commentRepository.delete(getDeletableAncestorComment(comment));
        }

        return new ApiResponseDto("관리자에 의한 댓글 삭제 성공", HttpStatus.OK.value());

    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
    }

    public Comment getDeletableAncestorComment(Comment comment) {
        Comment parent = comment.getParent();
        if(parent != null && parent.getChildren().size() == 1 && parent.getIsDeleted().equals(DeleteStatus.Y)) {
            return getDeletableAncestorComment(parent);
        }
        return comment;
    }

    private void convertComment(CommentResponseDto commentResponseDto, DeleteStatus isDeleted) {
        if(isDeleted.equals(DeleteStatus.Y)) {
            commentResponseDto.setContent("삭제된 댓글입니다.");
        }
    }
}
