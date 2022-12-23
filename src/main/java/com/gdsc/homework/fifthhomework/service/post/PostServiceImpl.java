package com.gdsc.homework.fifthhomework.service.post;

import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.domain.post.PostRepository;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByIdDescDto;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByLikesDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;


    @Transactional
    @Override
    public List<PostsOrderByIdDescDto> getPostsMain() {
        List<Post> findPosts = postRepository.findAllByOrderByIdDesc();
        List<PostsOrderByIdDescDto> results  = new ArrayList<>();
        for (Post findPost : findPosts) {
            PostsOrderByIdDescDto postDto = new PostsOrderByIdDescDto();
            postDto.setTitle(findPost.getTitle());
            postDto.setDescription(findPost.getDescription());
            results.add(postDto);
        }
        return results;
    }

    @Transactional
    @Override
    public List<PostsOrderByLikesDto> getPostsOrderByLike() {
        List<Post> findPosts = postRepository.findAllByOrderByLikeCountDesc();
        List<PostsOrderByLikesDto> results = new ArrayList<>();
        for (Post findPost : findPosts) {
            PostsOrderByLikesDto postDto = new PostsOrderByLikesDto();
            postDto.setTitle(findPost.getTitle());
            postDto.setDescription(findPost.getDescription());
            results.add(postDto);
        }
        return results;
    }

}
