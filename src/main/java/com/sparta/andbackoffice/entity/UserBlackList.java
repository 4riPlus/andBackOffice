package com.sparta.andbackoffice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Component
@Getter
@Setter
@Table(name = "UserBlackList")
@NoArgsConstructor
public class UserBlackList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blackListId")
    private Long blackListId;
    public String userName;

    @ManyToOne
    @JoinColumn(name = "userName")
    private User user;


    public UserBlackList(String userName) {
        this.userName = userName;
    }
}
