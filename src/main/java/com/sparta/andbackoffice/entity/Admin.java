package com.sparta.andbackoffice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id; // 관리자 아이디

    @Column(name = "company_no", nullable = false)
    private Long companyNo;
    @Column(name = "admin_name",nullable = false)
    private String adminName;
    @Column(name = "admin_password",nullable = false)
    private String adminPassword;

}
