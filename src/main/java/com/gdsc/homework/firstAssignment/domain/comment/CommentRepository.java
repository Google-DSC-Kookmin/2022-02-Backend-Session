package com.gdsc.homework.firstAssignment.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Modifying
    @Query(value = "DELETE FROM comment WHERE post_id = :postId AND user_id = :userId", nativeQuery = true)
    void deleteCommentByPostIdAndUserId(Long postId, Long userId);

}
