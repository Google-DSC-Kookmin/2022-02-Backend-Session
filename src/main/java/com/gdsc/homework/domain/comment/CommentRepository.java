package com.gdsc.homework.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Long> {
    Comments save(Comments comments);

    @Override
    void deleteById(Long id);
}
