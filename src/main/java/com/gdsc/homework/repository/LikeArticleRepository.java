package com.gdsc.homework.repository;

import com.gdsc.homework.domain.Article;
import com.gdsc.homework.domain.LikeArticle;
import com.gdsc.homework.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeArticleRepository extends JpaRepository<LikeArticle,Long> {
    LikeArticle findByUserAndArticle(User user, Article article);
}
