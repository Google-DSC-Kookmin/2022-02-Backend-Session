package com.gdsc.homework.validAPI;

import com.gdsc.homework.domain.post.Posts;
import com.gdsc.homework.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostValidation {
    private final PostRepository postRepository;

    public void userHasPost(String email, Posts posts) {
        validateUserWithPost(posts, email);
    }

    public void userHasPost(String email, Long postId) {
        presentPost(postId);
        Optional<Posts> NullablePost = postRepository.findById(postId);
        Posts posts = NullablePost.get();
        validateUserWithPost(posts, email);
    }
    private void validateUserWithPost(Posts posts, String email) {
        if (!posts.getAuther().getEmail().equals(email)) {
            throw new IllegalArgumentException("유저가 해당 포스트를 가지고 있지 않습니다.");
        }
    }

    public void presentPost(Optional<Posts> post) {
        if(!post.isPresent()) {
            throw new IllegalArgumentException("포스트가 존재하지 않습니다.");
        }
    }

    public void presentPost(Long postId) {
        if (!postRepository.findById(postId).isPresent()) {
            throw new IllegalArgumentException("포스트가 존재하지 않습니다.");
        }
    }
}
