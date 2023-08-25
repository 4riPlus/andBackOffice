package com.sparta.andbackoffice.entity;

import jakarta.persistence.*;

@Entity
public class Contest_BottomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="bottomcategory_id")
    private BottomCategory bottomCategory;

    @ManyToOne
    @JoinColumn(name="contest_id")
    private Contest contest;
}
  