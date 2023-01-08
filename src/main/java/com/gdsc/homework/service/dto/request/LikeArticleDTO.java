package com.gdsc.homework.service.dto.request;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LikeArticleDTO {
    private Long articleId;
    private Long userId;

    public static LikeArticleDTO of(Long articleIdId, Long userId) {
        return new LikeArticleDTO(articleIdId, userId);
    }
}
