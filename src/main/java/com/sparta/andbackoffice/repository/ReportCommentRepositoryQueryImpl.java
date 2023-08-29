package com.sparta.andbackoffice.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.andbackoffice.dto.response.ReportCommentCountResponseDto;
import com.sparta.andbackoffice.entity.QReportComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReportCommentRepositoryQueryImpl implements ReportCommentRepositoryQuery {
	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public List<ReportCommentCountResponseDto> getReportCommentCount() {
		QReportComment qReportComment = QReportComment.reportComment;

        return jpaQueryFactory.from(qReportComment)
                .groupBy(qReportComment.comment.id)
                .select(
                        Projections.constructor(
                                ReportCommentCountResponseDto.class,
                                qReportComment.comment.id,
                                qReportComment.comment.content,
                                qReportComment.count().as("reportCounts")
                        )
                )
                .orderBy(qReportComment.count().desc())
                .fetch();
    }
}
