package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
