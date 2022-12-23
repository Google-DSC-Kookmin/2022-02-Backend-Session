package com.gdsc.homework.service.dto.request;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleDTO {
    private String title;
    private String content;
    private Long userId;

    public static ArticleDTO of (String title, String content, Long userId){
        return new ArticleDTO(title, content, userId);
    }
}