package com.gdsc.homework.HW5.controller.likearticle.dto.request;

import com.gdsc.homework.HW5.service.likearticle.dto.request.LikeArticleServiceRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LikeArticleRequest {
    private Long articleId;
    private Long userId;

    public static LikeArticleServiceRequest toServiceDto(Long articleId, Long userId) {
        return LikeArticleServiceRequest.newInstance(articleId, userId);
    }
}
