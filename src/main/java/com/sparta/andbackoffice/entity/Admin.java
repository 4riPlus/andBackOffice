package com.sparta.andbackoffice.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="admin")
@NoArgsConstructor


public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_no", nullable = false)
    private Long companyNo;
    @Column(name = "admin_name",nullable = false)
    private String adminName;
    @Column(name = "admin_password",nullable = false)
    private String adminPassword;

    public Admin( Long companyNo,String adminName,String adminPassword){
        this.companyNo = companyNo;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    }
