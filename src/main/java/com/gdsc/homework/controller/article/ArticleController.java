package com.gdsc.homework.controller.article;

import com.gdsc.homework.config.BaseResponse;
import com.gdsc.homework.controller.article.dto.request.ArticleRequest;
import com.gdsc.homework.controller.article.dto.request.ArticleUpdateRequest;
import com.gdsc.homework.service.article.ArticleService;
import com.gdsc.homework.service.article.dto.response.ArticleDetailCommentsResponse;
import com.gdsc.homework.service.article.dto.response.ArticleDetailResponse;
import com.gdsc.homework.service.article.dto.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ArticleController {
    private final ArticleService articleService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping(value = "")
    public BaseResponse<ArticleResponse> articleWrite(@RequestBody @Valid final ArticleRequest request) {
        return new BaseResponse<>(articleService.writeArticle(request.toServiceDto()));
    }

    @PutMapping(value = "/{articleId}")
    public BaseResponse<ArticleResponse> articleUpdate(@PathVariable(value = "articleId", required = true) final Long articleId,
                                         @RequestBody @Valid final ArticleUpdateRequest request) {
        return new BaseResponse<>(articleService.updateArticle(articleId, request.toServiceDto()));

    }

    @DeleteMapping(value = "/{articleId}")
    public BaseResponse<String> articleDelete(@PathVariable(value = "articleId", required = true) final Long articleId) {
        return new BaseResponse<>(articleService.deleteArticle(articleId));
    }

    @GetMapping(value = "/{articleId}")
    public BaseResponse<ArticleDetailCommentsResponse> getArticle(@PathVariable(value = "articleId", required = true) final Long articleId) {
        return new BaseResponse<>(articleService.getArticle(articleId));
    }

    @GetMapping(value = "")
    public BaseResponse<List<ArticleDetailResponse>> getArticles(@RequestParam(value = "order", defaultValue = "latest") final String order) {
        return new BaseResponse<>(articleService.getArticles(order));
    }
}
