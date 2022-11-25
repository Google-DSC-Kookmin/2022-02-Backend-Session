package com.gdsc.homework.fourthHW.model;


import javax.persistence.*;


@Entity
public class Likes {

    @Id @GeneratedValue
    private Long likeID;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name="ARTICLE_ID")
    private Article article;
}
