package com.sparta.andbackoffice.entity;

import com.sparta.andbackoffice.dto.request.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

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

    @Column(name = "contents")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Board(Category categoryId, BoardRequestDto requestDto) {
        this.categoryId = categoryId;
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
