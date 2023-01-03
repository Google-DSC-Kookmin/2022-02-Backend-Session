package com.gdsc.homework.domain.likeArtlcle;

import com.gdsc.homework.domain.article.Articles;
import com.gdsc.homework.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeArticleRepository extends JpaRepository<Likes,Long> {
    Likes findByUsersAndArticles(Users users, Articles articles);
    Boolean existsByUsersAndArticles(Users users,Articles articles);
}
