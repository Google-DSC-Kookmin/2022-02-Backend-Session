package com.gdsc.homework.HW5.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private Like(Article article, User user) {
        this.article = article;
        this.user = user;
    }

    public static Like newInstance(Article article, User user) {
        return new Like(article, user);
    }
}
