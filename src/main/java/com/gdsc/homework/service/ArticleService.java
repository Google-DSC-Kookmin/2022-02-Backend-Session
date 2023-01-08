package com.gdsc.homework.service;

import com.gdsc.homework.domain.article.Articles;
import com.gdsc.homework.domain.user.Users;
import com.gdsc.homework.domain.article.ArticleRepository;
import com.gdsc.homework.service.dto.request.ArticleDTO;
import com.gdsc.homework.service.dto.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
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
        Users foundUsers = userService.getUser(articleDTO.getUserId());
        articleRepository.save(Articles.newInstance(articleDTO.getTitle(), articleDTO.getContent(), foundUsers));
    }
    public ArticleResponse update(ArticleDTO articleDTO){
        Articles getAticle = getArtcle(articleDTO.getArticleId());
        getAticle.updateTitleOrContent(articleDTO.getTitle(), articleDTO.getContent());
        Articles savedAticle = articleRepository.save(getAticle);
        return ArticleResponse.of(savedAticle.getArticleId(), savedAticle.getTitle(), savedAticle.getContent(), savedAticle.getUsers().getUserID());


    }

    public Articles getArtcle(Long articleId){
        Articles foundArticles = articleRepository.findByArticleId(articleId)
                .orElseThrow(() -> new IllegalArgumentException("없는 게시물입니다"));
        return foundArticles;

    }

    public void delete(Long articleId) {
        Articles foundArticles = getArtcle(articleId);
        articleRepository.delete(foundArticles);
    }

    public List<ArticleResponse> findByUserId(Long userId) {
        Users getUsers = userService.getUser(userId);
        List<Articles> myArticles = articleRepository.findByUsers(getUsers);
        List<ArticleResponse> articleResponses = myArticles.stream().map(ArticleResponse::new).collect(Collectors.toList());
        return articleResponses;
    }

    public List<ArticleResponse> moreLike() {
//        List<Articles> articles = articleRepository.findAllByOrderByLikeCountDesc(); // 좋아요 순으로만 정렬
//        List<Articles> arrayArticles = arrayArticles
        Sort sort = Sort.by( // 좋아요 내림차순, 게시글 최신순
                Sort.Order.desc("likeCount"),
                Sort.Order.desc("createDate")
        );
        List<Articles> arrayLikeCountToCreateDate = articleRepository.findAll(sort);
        List<ArticleResponse> articleResponses = arrayLikeCountToCreateDate.stream().map(ArticleResponse::new).collect(Collectors.toList());
        return articleResponses;

    }

    public List<ArticleResponse> recent() {
        List<Articles> articles = articleRepository.findAllByOrderByCreateDateDesc();
        List<ArticleResponse> articleResponses = articles.stream().map(ArticleResponse::new).collect(Collectors.toList());
        return articleResponses;
    }
}
