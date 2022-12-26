package com.gdsc.homework.domain.like;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    PostLike save(PostLike postLike);

    @Override
    void deleteById(Long id);
}
