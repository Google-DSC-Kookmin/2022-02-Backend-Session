package com.gdsc.homework.service.like;

import com.gdsc.homework.domain.like.PostLike;
import com.gdsc.homework.domain.like.PostLikeRepository;
import com.gdsc.homework.domain.post.Post;
import com.gdsc.homework.domain.post.PostRepository;
import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import com.gdsc.homework.service.like.dto.request.PostLikeServiceRequest;
import com.gdsc.homework.validAPI.PostValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostLikeService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final PostValidation postValidation;

    public final Long addLike(PostLikeServiceRequest postLikeServiceRequest) {
        postValidation.userHasPost(postLikeServiceRequest.getEmail(), postLikeServiceRequest.getPostId());
        Post post = postRepository.findById(postLikeServiceRequest.getPostId()).get();
        User user = userRepository.findByEmail(postLikeServiceRequest.getEmail()).get();
        presentPostLike(user, post);
        PostLike postLike = postLikeRepository.save(
                PostLike.newInstance(user,post)
        );
        return postLike.getId();
    }

    public final void deleteLike(Long postLikeId) {
        validatePostLike(postLikeId);
        postLikeRepository.deleteById(postLikeId);
    }
    // postlike 서비스 한 부분에서만 사용할 것 같기 때문에 따로 valid한지 구현하지 않음
    private void validatePostLike(Long postLikeId) {
        if(postLikeRepository.findById(postLikeId).isEmpty()){
            throw new IllegalArgumentException("post id가 존재하지 않음");
        }
    }

    private void presentPostLike(User user, Post post) {
        postLikeRepository.findByUserAndPost(user, post).ifPresent(
                postLike -> {throw new IllegalArgumentException("이미 좋아요를 눌렀습니다.");}
        );
    }
}
