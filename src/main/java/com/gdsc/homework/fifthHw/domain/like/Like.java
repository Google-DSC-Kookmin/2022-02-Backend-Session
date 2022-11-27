package com.gdsc.homework.fifthHw.domain.like;

import com.gdsc.homework.fifthHw.domain.article.Article;
import com.gdsc.homework.fifthHw.domain.user.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}
