package com.gdsc.homework.fourthHW.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id @GeneratedValue
    private Long commentID;
    @Column(name = "CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="ARTICLE_ID")
    private Article article;
}
