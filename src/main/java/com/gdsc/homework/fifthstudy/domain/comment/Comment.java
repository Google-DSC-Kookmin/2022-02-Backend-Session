package com.gdsc.homework.fifthstudy.domain.comment;

import com.gdsc.homework.fifthstudy.domain.article.Article;
import com.gdsc.homework.fifthstudy.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

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
