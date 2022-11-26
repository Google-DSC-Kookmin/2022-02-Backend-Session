package com.gdsc.homework.HW5.controller.likearticle.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LikeArticleResponse {
    private Long id;
    private Long articleId;
    private Long userId;

    public static LikeArticleResponse newInstance(Long id, Long articleId, Long userId) {
        return new LikeArticleResponse(id, articleId, userId);
    }
}
