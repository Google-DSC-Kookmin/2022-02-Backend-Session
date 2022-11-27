package com.gdsc.homework.fifthHw.domain.comment;

import com.gdsc.homework.fifthHw.domain.article.Article;
import com.gdsc.homework.fifthHw.domain.user.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column
    private String content;
}
