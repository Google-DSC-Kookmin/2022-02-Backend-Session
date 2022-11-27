package com.gdsc.homework.fifthHW.domain.comment;

import com.gdsc.homework.fifthHW.domain.article.Article;
import com.gdsc.homework.fifthHW.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    Id;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User    user;

    @Column
    private String  comment;

    private Comment(final Article article, final User user, final String comment) {
        this.article = article;
        this.user = user;
        this.comment = comment;
    }

    public static Comment newInstance(final Article article, final User user, final String comment) {
        return  new Comment(article, user, comment);
    }
}
