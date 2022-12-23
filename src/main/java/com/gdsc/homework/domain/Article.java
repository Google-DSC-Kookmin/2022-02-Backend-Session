package com.gdsc.homework.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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

    @OneToMany(mappedBy = "article")
    List<Comment> comments = new ArrayList<Comment>();



}
