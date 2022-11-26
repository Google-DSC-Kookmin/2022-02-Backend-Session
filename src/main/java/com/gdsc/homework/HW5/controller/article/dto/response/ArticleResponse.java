package com.gdsc.homework.HW5.controller.article.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleResponse {
    private Long id;
    private Long authorId;
    private String title;
    private String content;

    public static ArticleResponse newInstance(Long id, Long authorId, String title, String content) {
        return new ArticleResponse(id,authorId,title,content);
    }
}
