package com.sparta.andbackoffice.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String userPassword;

	@Column(name = "email", nullable = false, unique = true)
	private String userEmail;
//   private enum role;

	@Column(name = "nickname", nullable = false, unique = true)
	private String nickname;

//	private Long kakaoId;
//
//	private String googleId;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Post> myPostList = new ArrayList<>();

	// 북마크 전체 보기
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private List<Bookmark> bookmarkList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<ReportComment> reportCommentList = new ArrayList<>();

	public User(String userName, String userPassword, String userEmail) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
	}


	//클라이언트 서버 OAuth 로그인
//	public User(String userName, String userPassword, String nickname, Long kakaoId) {
//		this.userName = userName;
//		this.userPassword = userPassword;
//		this.nickname = nickname;
//		this.kakaoId = kakaoId;
//	}

//	public User(String userName, String userPassword, String nickname, String googleId) {
//		this.userName = userName;
//		this.userPassword = userPassword;
//		this.nickname = nickname;
//		this.googleId = googleId;
//	}
//
//	public User kakaoIdUpdate(Long kakaoId) {
//		this.kakaoId = kakaoId;
//		return this;
//	}
//
//	public User googleIdUpdate(String googleId) {
//		this.googleId = googleId;
//		return this;
//	}

}
