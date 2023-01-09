package com.gdsc.homework.domain.comment;

import com.gdsc.homework.domain.article.Article;
import com.gdsc.homework.domain.base.BaseTimeEntity;
import com.gdsc.homework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comments")
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long commentId;
    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private Comment(String content, User user, Article article) {
        this.content = content;
        this.user = user;
        this.article = article;
    }

    public static Comment newInstance(final String content, final User user, final Article article){
        return new Comment(content, user, article);
    }
}
