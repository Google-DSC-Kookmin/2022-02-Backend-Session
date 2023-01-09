package com.gdsc.homework.service.article.dto.response;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleResponse {
    private Long articleId;
    private String title;
    private String content;

    public static ArticleResponse newInstance(final Long articleId, final String title, final String content) {
        return new ArticleResponse(articleId, title, content);
    }
}
