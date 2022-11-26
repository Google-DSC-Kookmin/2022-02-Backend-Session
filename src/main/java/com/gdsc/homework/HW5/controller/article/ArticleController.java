package com.gdsc.homework.HW5.controller.article;

import com.gdsc.homework.HW5.controller.article.dto.request.ArticleRequest;
import com.gdsc.homework.HW5.controller.article.dto.response.ArticleResponse;
import com.gdsc.homework.HW5.service.article.ArticleService;
import com.gdsc.homework.HW5.service.article.dto.response.ArticleServiceResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
}
