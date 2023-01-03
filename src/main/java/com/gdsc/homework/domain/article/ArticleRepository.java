package com.gdsc.homework.domain.article;

import com.gdsc.homework.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Optional<Article> findByArticleId(Long articleId);
    List<Article> findByUser(User user);

    List<Article> findAllByOrderByLikeCountDesc();
    List<Article> findAllByOrderByCreateDateDesc();

}
