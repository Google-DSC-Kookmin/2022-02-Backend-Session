package com.gdsc.homework.HW5.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private String content;

    private Comment(Article article, User user, String content) {
        this.article = article;
        this.user = user;
        this.content = content;
    }

    public static Comment newInstance(Article article, User user, String content) {
        return new Comment(article, user, content);
    }
}
