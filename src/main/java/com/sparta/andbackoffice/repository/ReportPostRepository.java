package com.sparta.andbackoffice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.andbackoffice.entity.ReportPost;

public interface ReportPostRepository extends JpaRepository <ReportPost, Long> {
	Optional<ReportPost> findByPostId(Long id);
}
