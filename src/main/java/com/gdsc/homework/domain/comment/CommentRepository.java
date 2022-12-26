package com.gdsc.homework.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment save(Comment comment);

    @Override
    void deleteById(Long id);
}
