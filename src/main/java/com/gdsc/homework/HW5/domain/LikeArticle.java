package com.gdsc.homework.HW5.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
// Like가 SQL 예약어에 있어서 회피해야함
public class LikeArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private LikeArticle(Article article, User user) {
        this.article = article;
        this.user = user;
    }

    public static LikeArticle newInstance(Article article, User user) {
        return new LikeArticle(article, user);
    }
}
