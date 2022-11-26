package com.gdsc.homework.HW5.service.likearticle;

import com.gdsc.homework.HW5.domain.Article;
import com.gdsc.homework.HW5.domain.LikeArticle;
import com.gdsc.homework.HW5.domain.User;
import com.gdsc.homework.HW5.repository.ArticleRepository;
import com.gdsc.homework.HW5.repository.LikeArticleRepository;
import com.gdsc.homework.HW5.repository.UserRepository;
import com.gdsc.homework.HW5.service.likearticle.dto.request.LikeArticleServiceRequest;
import com.gdsc.homework.HW5.service.likearticle.dto.response.LikeArticleServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeArticleService {
    private final LikeArticleRepository likeArticleRepository;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    public LikeArticleServiceResponse save(LikeArticleServiceRequest likeArticleServiceRequest) {
        Optional<Article> optionalArticle = articleRepository.findById(likeArticleServiceRequest.getArticleId());
        validatePrsentArticle(optionalArticle);
        Article article = optionalArticle.get();

        Optional<User> optionalUser = userRepository.findById(likeArticleServiceRequest.getUserId());
        validatePresentUser(optionalUser);
        User user = optionalUser.get();

        LikeArticle likeArticle = likeArticleRepository.save(LikeArticle.newInstance(
                article, user));

        return LikeArticleServiceResponse.of(
                likeArticle.getId(),
                article.getId(),
                user.getId());
    }

    public LikeArticleServiceResponse findById(Long id) {
        Optional<LikeArticle> optional = likeArticleRepository.findById(id);
        validatePresentLikeArticle(optional);
        LikeArticle likeArticle = optional.get();

        return LikeArticleServiceResponse.of(
                likeArticle.getId(),
                likeArticle.getArticle().getId(),
                likeArticle.getUser().getId()
        );
    }

    private void validatePresentLikeArticle(Optional<LikeArticle> optional) {
        if(optional.isEmpty()) {
            throw new IllegalStateException("Like가 존재하지 않습니다.");
        }
    }

    private void validatePrsentArticle(Optional<Article> optional) {
        if(optional.isEmpty()) {
            throw new IllegalStateException("Article이 존재하지 않습니다.");
        }
    }

    private void validatePresentUser(Optional<User> optional) {
        if(optional.isEmpty()) {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }
    }
}
