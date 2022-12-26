package com.gdsc.homework.service;

import com.gdsc.homework.domain.Article;
import com.gdsc.homework.domain.User;
import com.gdsc.homework.repository.ArticleRepository;
import com.gdsc.homework.service.dto.request.ArticleDTO;
import com.gdsc.homework.service.dto.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserService userService;
    public void save(ArticleDTO articleDTO) {
        User foundUser = userService.getUser(articleDTO.getUserId());
        articleRepository.save(Article.newInstance(articleDTO.getTitle(), articleDTO.getContent(), foundUser));
    }
    public ArticleResponse update(ArticleDTO articleDTO){
        Article getAticle = getArtcle(articleDTO.getArticleId());
        getAticle.updateTitleOrContent(articleDTO.getTitle(), articleDTO.getContent());
        Article savedAticle = articleRepository.save(getAticle);
        return ArticleResponse.of(savedAticle.getArticleId(), savedAticle.getTitle(), savedAticle.getContent(), savedAticle.getUser().getUserID());


    }

    public Article getArtcle(Long articleId){
        Article foundArticle = articleRepository.findByArticleId(articleId)
                .orElseThrow(() -> new IllegalArgumentException("없는 게시물입니다"));
        return foundArticle;

    }

    public void delete(Long articleId) {
        Article foundArticle = getArtcle(articleId);
        articleRepository.delete(foundArticle);
    }

    public List<ArticleResponse> findByUserId(Long userId) {
        User getUser = userService.getUser(userId);
        List<Article> myArticles = articleRepository.findByUser(getUser);
        List<ArticleResponse> articleResponses = myArticles.stream().map(ArticleResponse::new).collect(Collectors.toList());
        return articleResponses;
    }
}
