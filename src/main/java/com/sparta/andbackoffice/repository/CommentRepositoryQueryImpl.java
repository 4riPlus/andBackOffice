package com.sparta.andbackoffice.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.andbackoffice.entity.Comment;
import com.sparta.andbackoffice.entity.QComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryQueryImpl implements CommentRepositoryQuery {
	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public List<Comment> getCommentListFindByPostId(Long postId) {
		QComment comment = QComment.comment;

		return jpaQueryFactory.selectFrom(comment)
				.where(comment.post.id.eq(postId))
				.orderBy(comment.parent.id.asc(), comment.createdDate.asc())
				.fetch();
	}
}
