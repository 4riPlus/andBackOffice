package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryQuery {

	List<Comment> findAllByPostId(Long postId);

	void deleteByPostId(Long id);
}
