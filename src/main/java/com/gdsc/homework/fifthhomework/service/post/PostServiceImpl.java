package com.gdsc.homework.fifthhomework.service.post;

import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.domain.post.PostRepository;
import com.gdsc.homework.fifthhomework.domain.user.User;
import com.gdsc.homework.fifthhomework.domain.user.UserRepository;
import com.gdsc.homework.fifthhomework.dto.post.request.PostPostDto;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByIdDescDto;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByLikesDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    private final UserRepository userRepository;


    @Transactional
    @Override
    public List<PostsOrderByIdDescDto> getPostsMain() {
        List<Post> findPosts = postRepository.findAllByOrderByIdDesc();
        List<PostsOrderByIdDescDto> results  = new ArrayList<>();
        for (Post findPost : findPosts) {
            PostsOrderByIdDescDto postDto = new PostsOrderByIdDescDto();
            postDto.setTitle(findPost.getTitle());
            postDto.setDescription(findPost.getDescription());
            postDto.setId(findPost.getId());
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
            postDto.setId(findPost.getId());
            results.add(postDto);
        }
        return results;
    }

    @Transactional
    @Override
    public void postPost(PostPostDto postPostDto) {
        User byId = userRepository.findById(postPostDto.getUserId())
                        .orElseThrow(()->new IllegalArgumentException("잘못된 사용자입니다."));
        Post post = Post.newInstance(postPostDto.getTitle(), postPostDto.getDescription(), byId);
        postRepository.save(post);
    }

    @Transactional
    @Override
    public void postUpdate(PostPostDto postPostDto,Long postId) {
        Post byId = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("없는 게시물입니다."));
        Post.updatePost(postPostDto,byId);
    }

    @Transactional
    @Override
    public void postDelete(Long postId) {
        Post byId = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("없는 게시물입니다."));
        postRepository.delete(byId);
    }

}
