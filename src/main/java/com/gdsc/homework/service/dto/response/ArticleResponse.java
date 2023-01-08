package com.gdsc.homework.service.dto.response;

import com.gdsc.homework.domain.article.Articles;
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

    public ArticleResponse(Articles articles) {
        this.articleId = articles.getArticleId();
        this.title = articles.getTitle();
        this.content = articles.getContent();
        this.userId = articles.getUsers().getUserID();
        this.likeCount = articles.getLikeCount();
        this.CreateDate = articles.getCreateDate();
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
