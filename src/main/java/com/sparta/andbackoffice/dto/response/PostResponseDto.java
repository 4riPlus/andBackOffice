package com.sparta.andbackoffice.dto.response;

import com.sparta.andbackoffice.entity.Post;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String contents;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
    }
}
