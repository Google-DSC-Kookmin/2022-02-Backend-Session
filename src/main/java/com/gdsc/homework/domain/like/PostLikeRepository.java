package com.gdsc.homework.domain.like;

import com.gdsc.homework.domain.post.Posts;
import com.gdsc.homework.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLikes, Long> {
    PostLikes save(PostLikes postLikes);

    @Override
    void deleteById(Long id);

    Optional<PostLikes> findByUserAndPost(User user, Posts posts);
}
