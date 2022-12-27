package com.gdsc.homework.service.dto.response;

import com.gdsc.homework.domain.Article;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleResponse {
    private Long articleId;
    private String title;
    private String content;
    private Long userId;
    private int likeCount;
    private LocalDateTime CreateDate;

    public ArticleResponse(Article article) {
        this.articleId = article.getArticleId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.userId = article.getUser().getUserID();
        this.likeCount = article.getLikeCount();
        this.CreateDate = article.getCreateDate();
    }

    public ArticleResponse(Long articleId, String title, String content, Long userId) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }


    public static ArticleResponse of(Long articleId, String title, String content, Long ussrId){
        return new ArticleResponse(articleId, title, content, ussrId);

    }

}
