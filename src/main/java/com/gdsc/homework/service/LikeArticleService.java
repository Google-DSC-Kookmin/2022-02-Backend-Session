package com.gdsc.homework.service;

import com.gdsc.homework.domain.Article;
import com.gdsc.homework.domain.LikeArticle;
import com.gdsc.homework.domain.User;
import com.gdsc.homework.repository.ArticleRepository;
import com.gdsc.homework.repository.LikeArticleRepository;
import com.gdsc.homework.service.dto.request.LikeArticleDTO;
import com.gdsc.homework.service.dto.response.LikeArticleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeArticleService {
    private final LikeArticleRepository likeArticleRepository;
    private final ArticleRepository articleRepository;
    private final UserService userService;
    private final ArticleService articleService;

    public LikeArticleResponse like(LikeArticleDTO likeArticleDTO) {
        User getUser = userService.getUser(likeArticleDTO.getUserId());
        Article getArticle = articleService.getArtcle(likeArticleDTO.getArticleId());
        if(likeArticleRepository.findByUserAndArticle(getUser, getArticle) != null){
            LikeArticle getLikeArticle = likeArticleRepository.findByUserAndArticle(getUser, getArticle);
            log.info("좋아요 취소");
            getArticle.unLike();
            articleRepository.save(getArticle);
            likeArticleRepository.delete(getLikeArticle);
            return LikeArticleResponse.of(getLikeArticle.getLikeID(), getArticle.getArticleId(),getUser.getUserID(),getArticle.getLikeCount());
        }
        LikeArticle savedLikeArticle = likeArticleRepository.save(LikeArticle.newInstance(getArticle, getUser));
        getArticle.like();
        articleRepository.save(getArticle);
        return LikeArticleResponse.of(savedLikeArticle.getLikeID(), getArticle.getArticleId(),getUser.getUserID(),getArticle.getLikeCount());
    }
}
