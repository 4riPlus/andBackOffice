package com.sparta.andbackoffice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ContestBottomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contest_bottom_category_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bottomcategory_id")
    private BottomCategory bottomCategory;

    @ManyToOne
    @JoinColumn(name = "contest_id")
    private Contest contest;

    public ContestBottomCategory(BottomCategory bottomCategory, Contest contest) {
        this.bottomCategory = bottomCategory;
        this.contest = contest;
    }
}
  