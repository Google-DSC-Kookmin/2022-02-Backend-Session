package com.gdsc.homework.hw5;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Comment")
@Getter
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String commentCd;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_CD")
    private ArticleEntity articleCd;

}
