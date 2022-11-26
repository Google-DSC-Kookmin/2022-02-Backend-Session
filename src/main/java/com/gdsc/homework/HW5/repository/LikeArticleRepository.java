package com.gdsc.homework.HW5.repository;

import com.gdsc.homework.HW5.domain.LikeArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeArticleRepository extends JpaRepository<LikeArticle, Long> {
    LikeArticle save(LikeArticle likeArticle);
    Optional<LikeArticle> findById(Long id);
}
