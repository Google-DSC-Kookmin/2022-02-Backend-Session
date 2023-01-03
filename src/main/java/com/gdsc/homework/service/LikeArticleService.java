package com.gdsc.homework.service;

import com.gdsc.homework.domain.article.Articles;
import com.gdsc.homework.domain.likeArtlcle.Likes;
import com.gdsc.homework.domain.user.Users;
import com.gdsc.homework.domain.article.ArticleRepository;
import com.gdsc.homework.domain.likeArtlcle.LikeArticleRepository;
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
        Users getUsers = userService.getUser(likeArticleDTO.getUserId());
        Articles getArticles = articleService.getArtcle(likeArticleDTO.getArticleId());
        if(likeArticleRepository.existsByUsersAndArticles(getUsers,getArticles)){
            return unlike(getUsers, getArticles);
        }
        return like(getUsers, getArticles);
    }
    private LikeArticleResponse unlike(Users getUsers, Articles getArticles){
        Likes getLikes = likeArticleRepository.findByUsersAndArticles(getUsers, getArticles);
        log.info("좋아요 취소");
        getArticles.unLike(); //--likeCounts
        articleRepository.save(getArticles); //좋아요 수 저장
        likeArticleRepository.delete(getLikes);
        return LikeArticleResponse.of(getLikes.getLikeID(), getArticles.getArticleId(), getUsers.getUserID(), getArticles.getLikeCount());
    }
    private LikeArticleResponse like(Users getUsers, Articles getArticles){
        Likes savedLikes = likeArticleRepository.save(Likes.newInstance(getArticles, getUsers));
        log.info("좋아요");
        getArticles.like(); //++likeCounts
        articleRepository.save(getArticles);
        return LikeArticleResponse.of(savedLikes.getLikeID(), getArticles.getArticleId(), getUsers.getUserID(), getArticles.getLikeCount());
    }
}
