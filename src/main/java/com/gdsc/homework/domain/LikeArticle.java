package com.gdsc.homework.domain;

import javax.persistence.*;

@Entity
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

}
