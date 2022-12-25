package com.gdsc.homework.controller.dto.response;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LikeArticleDTO {
    private Long likeArticleId;
    private Long articleId;
    private Long userId;
    private int likeCount;
    public static LikeArticleDTO of(Long likeArticleId, Long articleId, Long userId, int likeCount){
        return new LikeArticleDTO(likeArticleId, articleId, userId, likeCount);
    }

}
