package com.sparta.andbackoffice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Component
@Getter
@Table(name = "UserBlackList")
@NoArgsConstructor
public class UserBlackList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blackListId")
    private Long blackListId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public UserBlackList(Long blackListId) {
        this.blackListId = blackListId;
    }
}
