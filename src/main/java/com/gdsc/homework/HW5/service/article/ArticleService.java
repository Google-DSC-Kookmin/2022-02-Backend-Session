package com.gdsc.homework.HW5.service.article;

import com.gdsc.homework.HW5.domain.Article;
import com.gdsc.homework.HW5.domain.Comment;
import com.gdsc.homework.HW5.domain.LikeArticle;
import com.gdsc.homework.HW5.domain.User;
import com.gdsc.homework.HW5.repository.ArticleRepository;
import com.gdsc.homework.HW5.repository.UserRepository;
import com.gdsc.homework.HW5.service.article.dto.request.ArticleServiceRequest;
import com.gdsc.homework.HW5.service.article.dto.response.ArticleServiceResponse;
import com.gdsc.homework.HW5.service.comment.dto.response.CommentServiceResponse;
import com.gdsc.homework.HW5.service.likearticle.dto.response.LikeArticleServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public final ArticleServiceResponse postArticle(ArticleServiceRequest articleServiceRequest) {
        validatePresentUser(articleServiceRequest.getUserId());
        User user = userRepository.findById(articleServiceRequest.getUserId()).get();

        Article saveArticle = articleRepository.save(Article.newInstance(
                user,
                articleServiceRequest.getTitle(),
                articleServiceRequest.getContent()));

        return ArticleServiceResponse.of(
                saveArticle.getId(),
                saveArticle.getUser().getId(),
                saveArticle.getTitle(),
                saveArticle.getContent()
        );
    }

    public final ArticleServiceResponse findById(Long id) {
        Optional<Article> optional = articleRepository.findById(id);
        validatePresentArticle(optional);
        Article article = optional.get();
        return ArticleServiceResponse.of(
                article.getId(),
                article.getUser().getId(),
                article.getTitle(),
                article.getContent()
        );
    }

    public final List<CommentServiceResponse> findCommentsById(Long id) {
        Optional<Article> optional = articleRepository.findById(id);
        validatePresentArticle(optional);
        Article article = optional.get();
        List<Comment> comments = article.getComments();
        List<CommentServiceResponse> commentServiceResponseList = new ArrayList<CommentServiceResponse>();

        for(Comment comment:comments) {
            commentServiceResponseList.add(CommentServiceResponse.of(
                    comment.getId(),
                    comment.getArticle().getId(),
                    comment.getUser().getId(),
                    comment.getContent()));
        }

        return commentServiceResponseList;
    }

    public final List<LikeArticleServiceResponse> findLikeById(Long id) {
        Optional<Article> optional = articleRepository.findById(id);
        validatePresentArticle(optional);
        Article article = optional.get();

        List<LikeArticle> likes = article.getLikeArticles();
        List<LikeArticleServiceResponse> likeArticleServiceResponseList= new ArrayList<LikeArticleServiceResponse>();

        for(LikeArticle like: likes) {
            likeArticleServiceResponseList.add(LikeArticleServiceResponse.of(
                    like.getId(),like.getArticle().getId(), like.getUser().getId()));
        }

        return likeArticleServiceResponseList;
    }

    private void validatePresentArticle(Optional<Article> optional) {
        if(optional.isEmpty()) {
            throw new IllegalStateException("Article이 존재하지 않습니다.");
        }
    }

    private void validatePresentUser(Long userId) {
        Optional<User> optional = userRepository.findById(userId);
        if(optional.isEmpty()) {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }
    }


}
