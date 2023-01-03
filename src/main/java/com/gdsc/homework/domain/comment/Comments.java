package com.gdsc.homework.domain.comment;

import com.gdsc.homework.domain.article.Articles;
import com.gdsc.homework.domain.user.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users users;

    @ManyToOne
    @JoinColumn(name="article_id")
    Articles articles;

    private Comments(String content, Users users, Articles articles) {
        this.content = content;
        this.users = users;
        this.articles = articles;
    }

    public static Comments newInstance(String content, Users users, Articles articles){
        return new Comments(content, users, articles);
    }

}
