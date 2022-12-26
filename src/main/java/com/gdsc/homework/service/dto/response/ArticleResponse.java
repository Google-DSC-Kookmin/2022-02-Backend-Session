package com.gdsc.homework.service.dto.response;

import com.gdsc.homework.domain.Article;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleResponse {
    private Long articleId;
    private String title;
    private String content;
    private Long userId;

    public ArticleResponse(Article article) {
        this.articleId = article.getArticleId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.userId = article.getUser().getUserID();
    }


    public static ArticleResponse of(Long articleId, String title, String content, Long ussrId){
        return new ArticleResponse(articleId, title, content, ussrId);

    }
}
