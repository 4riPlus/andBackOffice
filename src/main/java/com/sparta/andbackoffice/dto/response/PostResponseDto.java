package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.Post;
import com.sparta.andbackoffice.entity.TimeStamped;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class PostResponseDto {
    private Long postId;
    private String title;
    private String contents;
    private String writer;
    private Long communityPostViews;
    private String modifiedDate;

    public PostResponseDto(Post post) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.writer = post.getUser().getNickname();
        this.contents = post.getContents();
        this.modifiedDate = post.getModifiedDateFormatted(TimeStamped.FORMATTER_DATE);
        this.communityPostViews = post.getPostviews();
    }
}
