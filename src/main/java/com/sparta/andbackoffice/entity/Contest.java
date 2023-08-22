package com.sparta.andbackoffice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contest")
@NoArgsConstructor
public class Contest extends TimeStamped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contest_id")
	private Long id;

	@Column(name = "category")
	private Long category;

	@Column(name = "author")
	private String author;

	@Column(name = "title")
	private String title;

	@Column(name = "company")
	private String company;

	@Column(name = "deadline")
	private String deadline;

	@Column(name = "homepage")
	private String homepage;

	@Column(name = "postViews")
	private Long contestPostViews;

	@Column(name = "contents")
	private String contents;
}
