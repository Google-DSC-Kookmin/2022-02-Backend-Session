package com.gdsc.homework.hw5;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Article")
@Getter
@NoArgsConstructor
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleCd;

    @Column
    private String author;

    @Column
    private String title;

    @Column
    private String content;

    @OneToMany(mappedBy = "Article")
    List<LikeEntity> likes = new ArrayList<LikeEntity>();

    @OneToMany(mappedBy = "Article")
    List<CommentEntity> comments = new ArrayList<CommentEntity>();
}
