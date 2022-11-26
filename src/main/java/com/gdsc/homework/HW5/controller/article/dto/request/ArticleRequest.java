package com.gdsc.homework.HW5.controller.article.dto.request;

import com.gdsc.homework.HW5.service.article.dto.request.ArticleServiceRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ArticleRequest {
    Long authorId;
    String title;
    String content;

    public static ArticleServiceRequest toServiceDto(Long authorId, String title, String content) {
        return ArticleServiceRequest.newInstance(
                authorId,
                title,
                content
        );
    }
}
