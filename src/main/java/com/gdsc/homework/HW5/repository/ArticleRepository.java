package com.gdsc.homework.HW5.repository;

import com.gdsc.homework.HW5.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article save(Article article);
    Optional<Article> findById(Long id);
}
