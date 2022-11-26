package com.gdsc.homework.HW5.repository.article.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleServiceResponse {
    private Long id;
    private Long autherId;
    private String title;
    private String content;

    public static ArticleServiceResponse of(Long id, Long autherId, String title, String content) {
        return new ArticleServiceResponse(id, autherId, title, content);
    }
}
