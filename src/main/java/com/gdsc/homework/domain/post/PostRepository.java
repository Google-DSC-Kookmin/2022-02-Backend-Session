package com.gdsc.homework.domain.post;

import com.gdsc.homework.domain.user.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Posts, Long> {
    Posts save(Posts posts);

    Optional<Posts> findById(Long id);

    List<Posts> findByAuther(User auther);

    List<Posts> findByAuther(User auther, Sort sort);

    @Override
    List<Posts> findAll(Sort sort);

    @Override
    void deleteById(Long id);
}
