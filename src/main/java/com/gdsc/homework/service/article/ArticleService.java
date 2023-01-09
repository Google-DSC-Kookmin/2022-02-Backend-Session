package com.gdsc.homework.service.article;

import com.gdsc.homework.config.security.JwtService;
import com.gdsc.homework.domain.article.Article;
import com.gdsc.homework.domain.article.ArticleRepository;
import com.gdsc.homework.domain.comment.Comment;
import com.gdsc.homework.domain.comment.CommentRepository;
import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import com.gdsc.homework.service.article.dto.request.ArticleDto;
import com.gdsc.homework.service.article.dto.response.ArticleDetailCommentsResponse;
import com.gdsc.homework.service.article.dto.response.ArticleDetailResponse;
import com.gdsc.homework.service.article.dto.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final JwtService jwtService;

    @Transactional
    public ArticleResponse writeArticle(final ArticleDto dto) {
        final Long userId = jwtService.getUserId();
        final User foundUser = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 회원 ID 입니다."));

        final Article newArticle = Article.newInstace(dto.getTitle(), dto.getContent(), foundUser);
        articleRepository.save(newArticle);

        return ArticleResponse.newInstance(newArticle.getArticleId(), newArticle.getTitle(), newArticle.getContent());
    }
    @Transactional
    public ArticleResponse updateArticle(final Long articleId, final ArticleDto dto) {
        final Long userId = jwtService.getUserId();
        final Article foundArticle = articleRepository.findArticleByArticleId(articleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 ID입니다."));

        validateArticleWriter(userId, foundArticle);
        foundArticle.updateContent(dto.getTitle(), dto.getContent());

        return ArticleResponse.newInstance(foundArticle.getArticleId(), foundArticle.getTitle(), foundArticle.getContent());
    }
    @Transactional
    public String deleteArticle(final Long articleId) {
        final Long userId = jwtService.getUserId();
        final Article foundArticle = articleRepository.findArticleByArticleId(articleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 ID입니다."));
        validateArticleWriter(userId, foundArticle);
        foundArticle.deleteArticle();
        return String.format("article #%d was deleted", foundArticle.getArticleId());
    }

    public List<ArticleDetailResponse> getArticles(final String order) {
        if (order.equals("likes")) {
            final List<Article> foundArticles = articleRepository.findAllOrderByLikeCount()
                    .orElseThrow(() -> new IllegalArgumentException("게시글을 불러오는 데에 실패하였습니다."));
            return foundArticles.stream()
                    .map(article -> ArticleDetailResponse.newInstance(
                    article.getArticleId(),
                    article.getTitle(),
                    article.getContent(),
                    article.getLikeCount(),
                    article.getCreatedAt(),
                    article.getModifiedAt()))
                    .collect(Collectors.toList());
        }
        final List<Article> foundArticles = articleRepository.findAllOrderByCreatedAt()
                    .orElseThrow(() -> new IllegalArgumentException("게시글을 불러오는 데에 실패하였습니다."));
            return foundArticles.stream()
                    .map(article -> ArticleDetailResponse.newInstance(
                            article.getArticleId(),
                            article.getTitle(),
                            article.getContent(),
                            article.getLikeCount(),
                            article.getCreatedAt(),
                            article.getModifiedAt()))
                    .collect(Collectors.toList());
    }

    public ArticleDetailCommentsResponse getArticle(final Long articleId) {
        final Article foundArticle = articleRepository.findArticleByArticleId(articleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 ID입니다."));
        checkDeleted(foundArticle);
        final List<Comment> foundComments = commentRepository.findAllByArticle(foundArticle).orElseGet(() -> Collections.emptyList());
//        List<Comment> foundComments = commentRepository.f(foundArticle);
        return ArticleDetailCommentsResponse.newInstance(foundArticle.getArticleId(), foundArticle.getTitle(),
                foundArticle.getContent(), foundArticle.getLikeCount(), foundComments, foundArticle.getCreatedAt(), foundArticle.getModifiedAt());
    }
    public void validateArticleWriter(final Long userId, final Article article) {
        final User foundUser = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 회원 ID 입니다."));
        if (!article.getUserId().equals(foundUser)){
            throw new IllegalArgumentException("게시물 수정이 불가능합니다.");
        }
    }
// 도메인에서 삭제되었는지를 체크하는게 나은지?
    public void checkDeleted(Article article) {
        if(article.checkDeleted()) throw new IllegalArgumentException("삭제된 게시물입니다.");
    }


}
