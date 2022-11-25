package com.gdsc.homework.fourthHW.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Article {
    @Id @GeneratedValue
    private Long articleID;
    @Column(name="AUTHOR")
    private String author;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private String content;

    @OneToMany(mappedBy = "article")
    List<Likes> likes = new ArrayList<Likes>();

    @OneToMany(mappedBy = "article")
    List<Comment> comments = new ArrayList<Comment>();

}
