package com.gdsc.homework.service.article.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleDetailResponse {
    private Long articleId;
    private String title;
    private String content;
    private Long likeCount;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public static ArticleDetailResponse newInstance(final Long articleId, final String title, final String content, final Long likeCount, final LocalDateTime createAt, final LocalDateTime modifiedAt) {
        return new ArticleDetailResponse(articleId, title, content, likeCount, createAt, modifiedAt);
    }
}
