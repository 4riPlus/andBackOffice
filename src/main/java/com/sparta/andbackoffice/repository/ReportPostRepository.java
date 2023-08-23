package com.sparta.andbackoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.andbackoffice.entity.ReportPost;

public interface ReportPostRepository extends JpaRepository <ReportPost, Long> {
}
