package com.gdsc.homework.HW5.controller.article;

import com.gdsc.homework.HW5.controller.article.dto.request.ArticleRequest;
import com.gdsc.homework.HW5.controller.article.dto.response.ArticleResponse;
import com.gdsc.homework.HW5.controller.comment.dto.response.CommentResponse;
import com.gdsc.homework.HW5.controller.likearticle.dto.response.LikeArticleResponse;
import com.gdsc.homework.HW5.service.article.ArticleService;
import com.gdsc.homework.HW5.service.article.dto.response.ArticleServiceResponse;
import com.gdsc.homework.HW5.service.comment.dto.response.CommentServiceResponse;
import com.gdsc.homework.HW5.service.likearticle.dto.response.LikeArticleServiceResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ArticleService articleService;

    @PostMapping(value = "/article", consumes = "application/json")
    public final ArticleResponse postArticle(@RequestBody ArticleRequest articleRequest) {
        logger.info("Post Article");
        ArticleServiceResponse articleServiceResponse = articleService.postArticle(
                articleRequest.toServiceDto(
                        articleRequest.getAuthorId(),
                        articleRequest.getTitle(),
                        articleRequest.getContent()
                )
        );

        return ArticleResponse.newInstance(
                articleServiceResponse.getId(),
                articleServiceResponse.getAutherId(),
                articleServiceResponse.getTitle(),
                articleServiceResponse.getContent()
        );
    }

    @GetMapping("/article/{id}")
    public final ArticleResponse getArticle(@PathVariable Long id) {
        logger.info("Get Article");
        ArticleServiceResponse articleServiceResponse = articleService.findById(id);

        return ArticleResponse.newInstance(
                articleServiceResponse.getId(),
                articleServiceResponse.getAutherId(),
                articleServiceResponse.getTitle(),
                articleServiceResponse.getContent()
        );
    }

    @GetMapping("/article/{id}/all-comment")
    public final List<CommentResponse> getAllComment(@PathVariable Long id) {
        logger.info("Get All Comment at Article Id: {}",id);
        List<CommentServiceResponse> commentServiceResponseList =  articleService.findCommentsById(id);
        List<CommentResponse> commentResponseList = new ArrayList<CommentResponse>();
        for(CommentServiceResponse comment:commentServiceResponseList) {
            commentResponseList.add(CommentResponse.newInstance(
                    comment.getId(),
                    comment.getArticleId(),
                    comment.getUserId(),
                    comment.getContent()
            ));
        }

        return commentResponseList;
    }

    @GetMapping("/article/{id}/all-like")
    public final List<LikeArticleResponse> getAllLike(@PathVariable Long id) {
        logger.info("Get All likes at Article Id: {}",id);
        List<LikeArticleServiceResponse> likeArticleServiceResponseList = articleService.findLikeById(id);
        List<LikeArticleResponse> likeArticleResponseList = new ArrayList<LikeArticleResponse>();
        for(LikeArticleServiceResponse like: likeArticleServiceResponseList) {
            likeArticleResponseList.add(LikeArticleResponse.newInstance(
               like.getId(),
               like.getArticleId(),
               like.getUserId()
            ));
        }

        return likeArticleResponseList;
    }
}
