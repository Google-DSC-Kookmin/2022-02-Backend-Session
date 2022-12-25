package com.gdsc.homework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class LikeArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeID;

    @ManyToOne
    @JoinColumn(name="article_id")
    Article article;
    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    public LikeArticle(Article article, User user) {
        this.article = article;
        this.user = user;
    }

    public static LikeArticle newInstance(Article article, User user){
        return new LikeArticle(article,user);
    }

}
