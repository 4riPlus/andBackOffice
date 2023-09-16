package com.sparta.andbackoffice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MiddleCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long middleCategoryId;

    @Column(nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "categoryId", orphanRemoval = true)
    private List<Board> boards;

    @OneToMany(mappedBy = "middleCategory", orphanRemoval = true)
    private List<BottomCategory> bottomCategories;


    public MiddleCategory(String categoryName) {
        this.categoryName = categoryName;
    }

}
