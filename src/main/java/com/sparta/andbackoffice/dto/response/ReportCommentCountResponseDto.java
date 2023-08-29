package com.sparta.andbackoffice.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReportCommentCountResponseDto {
    private Long commentId;
    private String content;
    private Long reportCommentCount;
}
