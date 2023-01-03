package com.gdsc.homework.domain.likeArtlcle;

import com.gdsc.homework.domain.article.Article;
import com.gdsc.homework.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeArticleRepository extends JpaRepository<LikeArticle,Long> {
    LikeArticle findByUserAndArticle(User user, Article article);
}
