package com.sparta.andbackoffice.entity;

import com.sparta.andbackoffice.dto.request.ContestRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "contest")
@NoArgsConstructor
@DynamicInsert
public class Contest extends TimeStamped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contest_id")
	private Long id;

	// 공모전 카테고리로 디폴트 id값 넣어주고 싶은데 1번 어떤가용
	@Column(name = "category")
	private Long category;

	@Column(name = "author", nullable = false)
	private String author;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "company", nullable = false)
	private String company;

	@Column(name = "endDate", nullable = false)
	private LocalDate endDate;

	@Column(name="startDate", nullable = false)
 	private LocalDate startDate;

	@Column(name="contest", nullable = false)
	private ContestStatus status;

	@Column(name = "homepage", nullable = false)
	private String homepage;

	@Column(columnDefinition = "integer default 0", nullable = false)
	private Long contestViews;

	@Column(name = "contents", nullable = false)
	private String contents;

	@OneToMany(mappedBy = "contest")
	private List<Contest_BottomCategory> bottomCategories = new ArrayList<>();

	public Contest(ContestRequestDto requestDto) {
		this.author = requestDto.getAuthor();
		this.title = requestDto.getTitle();
		this.company = requestDto.getCompany();
		this.endDate = requestDto.getEndDate();
		this.startDate = requestDto.getStartDate();
		this.status = requestDto.getStatus();
		this.homepage = requestDto.getHomepage();
		this.contents = requestDto.getContents();
	}

	// 값 입력이 없다면 default => 1번
	@PrePersist
	public void prePersist() {
		this.category = this.category == null ? 1 : this.category;
	}
}
