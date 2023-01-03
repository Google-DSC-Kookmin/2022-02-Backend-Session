package com.gdsc.homework.domain.comment;

import com.gdsc.homework.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Optional<Comment> findByCommentId(Long commendId);
}
