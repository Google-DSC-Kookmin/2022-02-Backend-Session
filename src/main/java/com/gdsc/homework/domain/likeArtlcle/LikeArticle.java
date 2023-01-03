package com.gdsc.homework.domain.likeArtlcle;

import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.article.Article;
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

    private LikeArticle(Article article, User user) {
        this.article = article;
        this.user = user;
    }

    public static LikeArticle newInstance(Article article, User user){
        return new LikeArticle(article,user);
    }

}
