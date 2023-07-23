package com.blog.min.service;

import com.blog.min.domain.member.Member;
import com.blog.min.domain.member.MemberRepository;
import com.blog.min.domain.posts.Posts;
import com.blog.min.domain.posts.PostsRepository;
import com.blog.min.web.posts.dto.PostsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(String name, PostsRequestDto dto) {
        Member member = memberRepository.findByName(name);
        dto.setMember(member);

        Posts posts = dto.toEntity();
        postsRepository.save(posts);

        return posts.getId();
    }
}
