package com.gdsc.homework.domain.comment;

import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.article.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name="article_id")
    Article article;

    private Comment(String content, User user, Article article) {
        this.content = content;
        this.user = user;
        this.article = article;
    }

    public static Comment newInstance(String content, User user, Article article){
        return new Comment(content, user, article);
    }

}
