package com.sseung.springsample.springboot.com.sseung.springsample.service.posts;

import com.sseung.springsample.springboot.com.sseung.springsample.domain.posts.Posts;
import com.sseung.springsample.springboot.com.sseung.springsample.domain.posts.PostsRepository;
import com.sseung.springsample.springboot.com.sseung.springsample.web.dto.PostsResponseDto;
import com.sseung.springsample.springboot.com.sseung.springsample.web.dto.PostsSaveRequestDto;
import com.sseung.springsample.springboot.com.sseung.springsample.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
