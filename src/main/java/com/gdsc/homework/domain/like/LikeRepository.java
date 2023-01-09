package com.gdsc.homework.domain.like;

import com.gdsc.homework.domain.article.Article;
import com.gdsc.homework.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findLikeByUserIdAndArticleId(User userId, Article articleId);
    boolean existsLikeByUserIdAndArticleId(User userId, Article articleId);
}
