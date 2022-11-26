package com.gdsc.homework.HW5.service.likearticle.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LikeArticleServiceResponse {
    Long id;
    Long articleId;
    Long userId;

    public static LikeArticleServiceResponse of(Long id, Long articleId, Long userId) {
        return new LikeArticleServiceResponse(id, articleId, userId);
    }
}
