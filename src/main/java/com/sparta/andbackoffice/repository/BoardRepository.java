package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
