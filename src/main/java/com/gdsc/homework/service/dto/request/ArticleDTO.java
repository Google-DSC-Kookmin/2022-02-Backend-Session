package com.gdsc.homework.service.dto.request;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleDTO {
    private Long articleId;
    private String title;
    private String content;
    private Long userId;

    public ArticleDTO(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public static ArticleDTO of (String title, String content, Long userId){
        return new ArticleDTO(title, content, userId);
    }
    public static ArticleDTO of (Long articleId,String title, String content, Long userId){
        return new ArticleDTO(articleId,title, content, userId);
    }
}