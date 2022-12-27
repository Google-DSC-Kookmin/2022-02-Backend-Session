package com.gdsc.homework.controller.dto.response;

import com.sun.jdi.connect.spi.TransportService;
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
    private int likeCount;

    public ArticleDTO(Long articleId, String title, String content, Long userId) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public static ArticleDTO of(Long articleId, String title, String content, Long ussrId){
        return new ArticleDTO(articleId, title, content, ussrId);

    }
    public static ArticleDTO of(Long articleId, String title, String content, Long ussrId,int likeCount){
        return new ArticleDTO(articleId, title, content, ussrId, likeCount);

    }
}
