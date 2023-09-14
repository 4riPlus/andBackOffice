package com.sparta.andbackoffice.repository;

import java.util.Optional;

import com.sparta.andbackoffice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
	Optional<Post> findById(Long postId);
}
