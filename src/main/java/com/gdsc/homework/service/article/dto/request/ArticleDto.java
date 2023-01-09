package com.gdsc.homework.service.article.dto.request;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleDto {
    private String title;
    private String content;
    public static ArticleDto of(final String title, final String content) {
        return new ArticleDto(title, content);
    }
}
