package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.S3File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmazonS3Repository extends JpaRepository<S3File, Long> {
}
