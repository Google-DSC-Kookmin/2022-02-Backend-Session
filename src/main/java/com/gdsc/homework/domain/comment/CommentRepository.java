package com.gdsc.homework.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comments,Long> {
    Optional<Comments> findByCommentId(Long commendId);
}
