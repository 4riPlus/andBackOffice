package com.sparta.andbackoffice.repository;

import com.sparta.andbackoffice.entity.ReportComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportCommentRepository extends JpaRepository<ReportComment, Long>, ReportCommentRepositoryQuery {

}
