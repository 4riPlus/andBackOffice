package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface ContestRepository extends JpaRepository<Contest, Long> {

    List<Contest> findByEndDate(LocalDateTime endDate);
}