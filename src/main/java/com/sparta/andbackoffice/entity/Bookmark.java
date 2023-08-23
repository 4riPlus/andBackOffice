package com.sparta.andbackoffice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "bookmarks")
public class Bookmark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "contest_post_id", nullable = false)
	private ContestPost contestPost;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	public Bookmark(ContestPost contestPost) {
		this.contestPost = contestPost;
	}
}
