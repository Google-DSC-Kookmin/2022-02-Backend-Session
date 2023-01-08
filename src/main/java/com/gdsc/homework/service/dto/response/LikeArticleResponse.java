package com.gdsc.homework.service.dto.response;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LikeArticleResponse {
    private Long likeArticleId;
    private Long articleId;
    private Long userId;
    private int likeCount;

    public static LikeArticleResponse of(Long likeArticleId, Long articleId, Long userId, int likeCount){
        return new LikeArticleResponse(likeArticleId, articleId, userId, likeCount);
    }
}
