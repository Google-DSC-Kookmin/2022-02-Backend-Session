package com.gdsc.homework.controller.like;

import com.gdsc.homework.config.BaseResponse;
import com.gdsc.homework.service.like.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/likes")
public class LikeController {
    private final LikeService likeService;

    @PostMapping(value = "/{articleId}")
    public BaseResponse<String> postLike(@PathVariable(value = "articleId", required = true) final Long articleId) {
        return new BaseResponse<>(likeService.postLike(articleId));
    }
    @DeleteMapping(value = "/{articleId}")
    public BaseResponse<String> deleteLike(@PathVariable(value = "articleId", required = true) final Long articleId) {
        return new BaseResponse<>(likeService.deleteLike(articleId));
    }
}
