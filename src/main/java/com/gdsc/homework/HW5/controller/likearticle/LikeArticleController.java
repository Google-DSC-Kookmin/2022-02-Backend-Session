package com.gdsc.homework.HW5.controller.likearticle;

import com.gdsc.homework.HW5.controller.likearticle.dto.request.LikeArticleRequest;
import com.gdsc.homework.HW5.controller.likearticle.dto.response.LikeArticleResponse;
import com.gdsc.homework.HW5.service.likearticle.LikeArticleService;
import com.gdsc.homework.HW5.service.likearticle.dto.response.LikeArticleServiceResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LikeArticleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final LikeArticleService likeArticleService;

    @PostMapping(value = "/like", consumes = "application/json")
    public final LikeArticleResponse postLike(@RequestBody LikeArticleRequest likeArticleRequest) {
        LikeArticleServiceResponse likeArticleServiceResponse = likeArticleService.save(LikeArticleRequest.toServiceDto(
                likeArticleRequest.getArticleId(),
                likeArticleRequest.getUserId()
        ));

        return LikeArticleResponse.newInstance(
                likeArticleServiceResponse.getId(),
                likeArticleServiceResponse.getArticleId(),
                likeArticleServiceResponse.getUserId()
        );
    }

    @GetMapping("/like/{id}")
    public final LikeArticleResponse getLike(@PathVariable Long id) {
        LikeArticleServiceResponse likeArticleServiceResponse = likeArticleService.findById(id);

        return LikeArticleResponse.newInstance(
                likeArticleServiceResponse.getId(),
                likeArticleServiceResponse.getArticleId(),
                likeArticleServiceResponse.getUserId()
        );
    }
}
