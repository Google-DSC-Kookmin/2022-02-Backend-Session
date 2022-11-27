package com.gdsc.homework.fifthHW.domain.comment;

import com.gdsc.homework.fifthHW.domain.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findCommentByArticle(Article article);
}
