package com.gdsc.homework.repository;

import com.gdsc.homework.domain.Article;
import com.gdsc.homework.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Optional<Article> findByArticleId(Long articleId);
    List<Article> findByUser(User user);

}
