package com.sparta.andbackoffice.entity;

import jakarta.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 관리자 아이디

    @Column(name = "company_no", nullable = false)
    private Long companyNo;
    @Column(name = "admin_name",nullable = false)
    private String adminName;
    @Column(name = "admin_password",nullable = false)
    private String adminPassword;

}
