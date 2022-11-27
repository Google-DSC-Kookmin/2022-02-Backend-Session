package com.gdsc.homework.fifthHW.domain.like;

import com.gdsc.homework.fifthHW.domain.article.Article;
import com.gdsc.homework.fifthHW.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    Id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    private Like(final User user, final Article article) {
        this.user = user;
        this.article = article;
    }

    public static Like newInstance(final User user, final Article article) {
        return  new Like(user, article);
    }

}
