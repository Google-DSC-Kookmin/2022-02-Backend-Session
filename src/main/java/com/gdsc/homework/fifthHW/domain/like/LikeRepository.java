package com.gdsc.homework.fifthHW.domain.like;

import com.gdsc.homework.fifthHW.domain.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Article> findLikeByArticle(Article article);
}
