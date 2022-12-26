package com.gdsc.homework.domain.post;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post save(Post post);

    Optional<Post> findById(Long id);

    @Override
    List<Post> findAll(Sort sort);

    @Override
    void deleteById(Long id);
}
