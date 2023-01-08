package com.gdsc.homework.domain.likeArtlcle;

import com.gdsc.homework.domain.article.Articles;
import com.gdsc.homework.domain.user.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "likes")
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeID;

    @ManyToOne
    @JoinColumn(name="article_id")
    Articles articles;
    @ManyToOne
    @JoinColumn(name="user_id")
    Users users;

    private Likes(Articles articles, Users users) {
        this.articles = articles;
        this.users = users;
    }

    public static Likes newInstance(Articles articles, Users users){
        return new Likes(articles, users);
    }

}
