package com.sparta.andbackoffice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

	// 공모전 카테고리로 디폴트 id값 넣어주고 싶은데 1번 어떤가용
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


	// 북마크 카운트
	@Column
	private Long bookmarkCnt;

	// 북마크
	@OneToMany(mappedBy = "contestPost", cascade = CascadeType.REMOVE)
	private List<Bookmark> bookmarkList = new ArrayList<>();

	@OneToMany(mappedBy = "contest")
	private List<Contest_BottomCategory> bottomCategories = new ArrayList<>();

}
