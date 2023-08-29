package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestRepository extends JpaRepository<Contest, Long> {
}
