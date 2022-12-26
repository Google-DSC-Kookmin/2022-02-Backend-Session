package com.gdsc.homework.firstAssignment.service.like;

import com.gdsc.homework.firstAssignment.domain.like.Like;
import com.gdsc.homework.firstAssignment.domain.like.LikeRepository;
import com.gdsc.homework.firstAssignment.domain.post.Post;
import com.gdsc.homework.firstAssignment.domain.post.PostRepository;
import com.gdsc.homework.firstAssignment.domain.user.User;
import com.gdsc.homework.firstAssignment.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public void likePost(final Long postId, final Long userId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 post id 입니다."));
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 bill id 입니다."));
        likeRepository.save(Like.newInstance(post, user));
        int likeCount = likeRepository.countByPostId(postId);
        post.setLikeCount(likeCount);
        postRepository.save(post);
    }

    @Transactional
    public void deletePost(final Long postId, final Long userId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 post id 입니다."));
        likeRepository.unlike(postId, userId);
        int likeCount = likeRepository.countByPostId(postId);
        post.setLikeCount(likeCount);
        postRepository.save(post);
    }

}
