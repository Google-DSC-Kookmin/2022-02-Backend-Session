package com.gdsc.homework.HW5.repository.article;

import com.gdsc.homework.HW5.domain.Article;
import com.gdsc.homework.HW5.domain.User;
import com.gdsc.homework.HW5.repository.ArticleRepository;
import com.gdsc.homework.HW5.repository.UserRepository;
import com.gdsc.homework.HW5.repository.article.dto.request.ArticleServiceRequest;
import com.gdsc.homework.HW5.repository.article.dto.response.ArticleServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
