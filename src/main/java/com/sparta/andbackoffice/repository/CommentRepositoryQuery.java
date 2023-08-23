package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.Comment;

import java.util.List;

public interface CommentRepositoryQuery {
	List<Comment> getCommentListFindByPostId(Long postId);
}
