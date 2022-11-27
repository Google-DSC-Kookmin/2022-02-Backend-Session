package com.gdsc.homework.fifthHw.domain.article;
import com.gdsc.homework.fifthHw.domain.user.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Article {

    @Id
    @Column(name = "article_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Column
    private String title;

    @Column
    private String content;
}
