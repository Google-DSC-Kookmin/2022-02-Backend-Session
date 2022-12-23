package com.gdsc.homework.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(name="nickname")
    private String nickName;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "user")
    List<Article> articles = new ArrayList<Article>();

    @OneToMany(mappedBy = "user")
    List<LikeArticle> likeArticles = new ArrayList<LikeArticle>();

    @OneToMany(mappedBy = "user")
    List<Comment> comments = new ArrayList<Comment>();

}
