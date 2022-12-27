package com.gdsc.homework.fifthhomework.service.like;


import com.gdsc.homework.fifthhomework.domain.like.Like;
import com.gdsc.homework.fifthhomework.domain.like.LikeRepository;
import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.domain.post.PostRepository;
import com.gdsc.homework.fifthhomework.domain.user.User;
import com.gdsc.homework.fifthhomework.domain.user.UserRepository;
import com.gdsc.homework.fifthhomework.dto.like.response.LikeResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService{

    private final LikeRepository likeRepository;

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    @Transactional
    @Override
    public LikeResponseDto getLike(Long postId, String email) {
        User user = checkUser(email);
        Post post = checkPost(postId);
        Optional<Like> findLike = likeRepository.findByUserAndPost(user, post);
        Long countLikes = likeRepository.countByIsLikeTrueAndPost(post);
        LikeResponseDto likeResponseDto = new LikeResponseDto();
        if(findLike.isEmpty()){
            likeResponseDto.setLike(false);
            likeResponseDto.setCountLike(countLikes);
            return likeResponseDto;
        }
        likeResponseDto.setLike(findLike.get().getIsLike());
        likeResponseDto.setCountLike(countLikes);
        return likeResponseDto;
    }

    @Transactional
    @Override
    public void postLike(Long postId, String email) {
        User user = checkUser(email);
        Post post = checkPost(postId);
        Optional<Like> findLike = likeRepository.findByUserAndPost(user, post);
        if(findLike.isEmpty()){
            Like like = Like.newInstance(user,post);
            likeRepository.save(like);
            return;
        }
        findLike.get().update();

    }

    private Post checkPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("없는 포스트입니다."));
    }

    private User checkUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException("없는 사용자입니다."));
    }
}
