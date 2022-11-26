package com.gdsc.homework.HW5.service.likearticle.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class LikeArticleServiceRequest {
    private Long articleId;
    private Long userId;

    public static LikeArticleServiceRequest newInstance(Long articleId, Long userId) {
        return new LikeArticleServiceRequest(articleId, userId);
    }
}
