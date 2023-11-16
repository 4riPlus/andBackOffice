package com.sparta.andbackoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.andbackoffice.entity.BoardCategory;

public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Long> {
}
