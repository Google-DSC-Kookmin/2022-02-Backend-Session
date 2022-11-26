package com.gdsc.homework.HW5.repository.article.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleServiceRequest {
    private Long userId;
    private String title;
    private String content;

    public static ArticleServiceRequest newInstance(Long userId, String title, String content) {
        return new ArticleServiceRequest(userId, title, content);
    }
}
