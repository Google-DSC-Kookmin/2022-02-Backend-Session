package com.gdsc.homework.HW5.service.article.dto.request;

import com.gdsc.homework.HW5.domain.Article;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleServiceRequest {
    Long userId;
    String title;
    String content;

    public static ArticleServiceRequest newInstance(Long userId, String title, String content) {
        return new ArticleServiceRequest(userId, title, content);
    }
}
