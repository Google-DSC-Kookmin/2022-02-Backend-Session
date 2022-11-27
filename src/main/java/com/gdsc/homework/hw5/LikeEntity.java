package com.gdsc.homework.hw5;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Like")
@Getter
@NoArgsConstructor
public class LikeEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userId;

    @Id
    @ManyToOne
    @JoinColumn(name = "ARTICLE_CD")
    private ArticleEntity articleCd;

}
