package com.gdsc.homework.fifthhomework.domain.like;

import com.gdsc.homework.fifthhomework.domain.article.Article;
import com.gdsc.homework.fifthhomework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Like {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;


    @Column
    private Boolean like;


    public Like(User user, Article article, Boolean like) {
        this.user = user;
        this.article = article;
        this.like = like;
    }

    public static Like newInstance(final User user, final Article article, final Boolean like){
        return new Like(user,article,like);
    }
}
