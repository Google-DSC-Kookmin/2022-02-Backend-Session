package com.gdsc.homework.firstAssignment.domain.like;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    int countByPostId(Long postId);
    @Modifying
    @Query(value = "DELETE FROM like WHERE post_id = :postId AND user_id = :userId", nativeQuery = true)
    void unlike(Long postId, Long userId);
}
