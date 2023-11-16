package com.sparta.andbackoffice.entity;

import org.hibernate.annotations.DynamicInsert;

import com.sparta.andbackoffice.dto.request.BoardRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "Board")
@DynamicInsert
@NoArgsConstructor
public class Board extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;


    @Column(name = "title")
    private String title;

    @Column(name = "contents", length = 500)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private BoardCategory category;

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Board(BoardRequestDto requestDto) {
        this.category = category;
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
