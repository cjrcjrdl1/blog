package com.blog.min.web.posts.dto;

import com.blog.min.domain.member.Member;
import com.blog.min.domain.posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsRequestDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private int view;
    private Member member;

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .member(member)
                .view(view)
                .build();
    }
}
