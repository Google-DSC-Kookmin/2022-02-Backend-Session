package com.gdsc.homework.fifthHW.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @ManyToOne
    @JoinColumn(name = "author")
    private User user;

    @Column
    private String title;

    @Column
    private String content;

    @OneToMany(mappedBy = "article")
    List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "article")
    List<Liked> likes = new ArrayList<Liked>();
}
