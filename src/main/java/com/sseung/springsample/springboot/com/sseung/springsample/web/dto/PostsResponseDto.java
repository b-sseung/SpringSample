package com.sseung.springsample.springboot.com.sseung.springsample.web.dto;

import com.sseung.springsample.springboot.com.sseung.springsample.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title, content, author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
