package com.gdsc.homework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.internal.util.privilegedactions.NewInstance;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Article extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "article")
    List<LikeArticle> likeArticles = new ArrayList<LikeArticle>();

    public Article(String title, String content,User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    @OneToMany(mappedBy = "article")
    List<Comment> comments = new ArrayList<Comment>();
    public static Article newInstance(final String title, final String content, final User user) {
        return new Article(title, content, user);
    }


}
