package com.gdsc.homework.domain.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findArticleByArticleId(Long articleId);
    @Query("select a from Article a order by a.likeCount DESC")
    Optional<List<Article>> findAllOrderByLikeCount();
    @Query("select a from Article a order by a.createdAt DESC")
    Optional<List<Article>> findAllOrderByCreatedAt();
}
