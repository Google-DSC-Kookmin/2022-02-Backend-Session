package com.gdsc.homework.domain.like;

import com.gdsc.homework.domain.post.Post;
import com.gdsc.homework.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    PostLike save(PostLike postLike);

    @Override
    void deleteById(Long id);

    Optional<PostLike> findByUserAndPost(User user, Post post);
}
