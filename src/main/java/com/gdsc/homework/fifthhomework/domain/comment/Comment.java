package com.gdsc.homework.fifthhomework.domain.comment;


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
public class Comment {


    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    @JoinColumn(name = "ARTICLE_KEY")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "USER_KEY")
    private User user;

    @Column
    private String title;

    @Column
    private String content;


    public Comment(Article article, User user, String title, String content) {
        this.article = article;
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public static Comment newInstance(final Article article, final User user, final String title, final String content){
        return new Comment(article,user,title,content);
    }
}
