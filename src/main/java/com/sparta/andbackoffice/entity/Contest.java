package com.sparta.andbackoffice.entity;

import com.sparta.andbackoffice.dto.request.ContestRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;
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

	@Column(name = "category")
	private Long category;

	@Column(name = "target", nullable = false)
	private String target;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "company", nullable = false)
	private String company;

	@Column(name = "endDate", nullable = false)
	private LocalDateTime endDate;

	@Column(name = "startDate")
	private LocalDateTime startDate;

	@Enumerated(EnumType.STRING) //enum의 값을 텍스트 값으로 저장
	@Column(name = "status")
	private ContestStatus status;

	@Column(name = "homepage", nullable = false)
	private String homepage;

	@Column(name = "contents", nullable = false)
	private String contents;

	@Column(name = "contestViews")
	private Long contestViews = 0L;

	@Column(name = "prize")
	private String prize;

	@Column(name = "S3Files")
	@OneToMany(mappedBy = "contest", cascade = CascadeType.REMOVE)
	private List<S3File> S3Files = new ArrayList<>();

	/*@OneToMany(mappedBy = "contest")
	private List<Contest_BottomCategory> bottomCategories = new ArrayList<>();*/

	public Contest(ContestRequestDto requestDto) {
		this.target = requestDto.getTarget();
		this.title = requestDto.getTitle();
		this.company = requestDto.getCompany();
		this.endDate = requestDto.getEndDate();
		this.startDate = requestDto.getStartDate();
		this.homepage = requestDto.getHomepage();
		this.contents = requestDto.getContents();
		this.prize = requestDto.getPrize();
	}


	public void setS3Files(S3File s3File) {
		this.S3Files.add(s3File);
	}
}

	// 값 입력이 없다면 default => 1번
//	@PrePersist
//	public void prePersist() {
//		this.category = this.category == null ? 1 : this.category;
////		this.contestViews = this.contestViews == null ? 0 : this.contestViews;
//	}
//}