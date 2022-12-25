package com.gdsc.homework.controller.dto.response;

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


    public static ArticleDTO of(Long articleId, String title, String content, Long ussrId){
        return new ArticleDTO(articleId, title, content, ussrId);

    }
}
