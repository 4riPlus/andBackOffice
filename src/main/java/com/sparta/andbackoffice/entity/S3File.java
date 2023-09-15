package com.sparta.andbackoffice.entity;

import com.sparta.andbackoffice.dto.request.S3FileDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "s3files")
public class S3File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;
    @Column
    private String originalFileName;
    @Column
    private String uploadFileName;

    @Column
    private String uploadFilePath;

    @Column
    private String uploadFileUrl;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "contest_id", nullable = false)
    private Contest contest;

    public S3File(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public S3File(String ofn, String ufn, String ufp, String ufu, Contest contest) {
        this.originalFileName = ofn;
        this.uploadFileName = ufn;
        this.uploadFilePath = ufp;
        this.uploadFileUrl = ufu;
        this.contest = contest;
    }

    public S3File(S3FileDto s3FileDto) {
        this.originalFileName = s3FileDto.getOriginalFileName();
        this.uploadFileName = s3FileDto.getUploadFileName();
        this.uploadFilePath = s3FileDto.getUploadFilePath();
        this.uploadFileUrl = s3FileDto.getUploadFileUrl();
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }
}
