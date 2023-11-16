package com.sparta.andbackoffice.entity;

import java.util.List;

import com.sparta.andbackoffice.dto.request.BoardCategoryRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
public class BoardCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String categoryName;

	@OneToMany(mappedBy = "category", orphanRemoval = true)
	private List<Board> boards;

	public BoardCategory(BoardCategoryRequestDto requestDto){
		this.categoryName = requestDto.getCategoryName();
	}

	public void updateCategory(BoardCategoryRequestDto requestDto){
		this.categoryName = requestDto.getCategoryName();
	}


}
