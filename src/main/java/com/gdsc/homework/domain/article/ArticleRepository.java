package com.gdsc.homework.domain.article;

import com.gdsc.homework.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Articles,Long> {
    Optional<Articles> findByArticleId(Long articleId);
    List<Articles> findByUsers(Users users);

//    List<Articles> findAllByOrderByLikeCountDesc();
    List<Articles> findAllByOrderByCreateDateDesc();

}
