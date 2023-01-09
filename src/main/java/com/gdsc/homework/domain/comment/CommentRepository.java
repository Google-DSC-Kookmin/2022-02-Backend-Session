package com.gdsc.homework.domain.comment;

import com.gdsc.homework.domain.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findCommentByCommentId(Long commentId);
    Optional<List<Comment>> findAllByArticle(Article articleId);
}
