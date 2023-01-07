package com.gdsc.homework.service.like;

import com.gdsc.homework.domain.like.PostLikes;
import com.gdsc.homework.domain.like.PostLikeRepository;
import com.gdsc.homework.domain.post.Posts;
import com.gdsc.homework.domain.post.PostRepository;
import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import com.gdsc.homework.service.like.dto.request.DeletePostLikeServiceRequest;
import com.gdsc.homework.service.like.dto.request.PostLikeServiceRequest;
import com.gdsc.homework.validAPI.PostValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostLikeService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final PostValidation postValidation;

    public final Long addLike(final PostLikeServiceRequest postLikeServiceRequest) {
        postValidation.userHasPost(postLikeServiceRequest.getEmail(), postLikeServiceRequest.getPostId());
        final Posts posts = postRepository.findById(postLikeServiceRequest.getPostId()).get();
        final User user = userRepository.findByEmail(postLikeServiceRequest.getEmail()).get();
        presentPostLike(user, posts);
        return postLikeRepository.save(
                PostLikes.newInstance(user, posts)
        ).getId();
    }

    public final void deleteLike(final DeletePostLikeServiceRequest deletePostLikeServiceRequest) {
        PostLikes postLikes = postLikeRepository.findById(deletePostLikeServiceRequest.getPostLikeId()).orElseThrow(
                () -> new IllegalArgumentException("postlike id가 존재하지 않음")
        );
        validatePostLikeWithUser(deletePostLikeServiceRequest.getEmail(), postLikes);
        postLikeRepository.deleteById(deletePostLikeServiceRequest.getPostLikeId());
    }

    private void presentPostLike(User user, Posts posts) {
        postLikeRepository.findByUserAndPosts(user, posts).ifPresent(
                postLikes -> {throw new IllegalArgumentException("이미 좋아요를 눌렀습니다.");}
        );
    }

    private void validatePostLikeWithUser(String email, PostLikes postLikes) {
        if(!postLikes.getUser().getEmail().equals(email)) {
            throw new IllegalArgumentException("해당 유저가 좋아요(id)를 누르지 않았습니다.");
        }
    }
}
