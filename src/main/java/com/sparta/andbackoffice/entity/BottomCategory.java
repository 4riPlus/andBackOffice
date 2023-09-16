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
@NoArgsConstructor
public class BottomCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bottomCategoryId;

    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "middle_category_id")
    private MiddleCategory middleCategory;


    @OneToMany(mappedBy = "bottomCategory", orphanRemoval = true)
    private List<ContestBottomCategory> contestList = new ArrayList<>();

    public  BottomCategory (String categoryName){
        this.categoryName=categoryName;
    }
}
