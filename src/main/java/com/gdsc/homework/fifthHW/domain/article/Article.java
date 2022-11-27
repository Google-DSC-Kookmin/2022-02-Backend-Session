package com.gdsc.homework.fifthHW.domain.article;

import com.gdsc.homework.fifthHW.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    Id;

    @Column
    private String  title;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private User user;

    @Column
    private String  context;

    private Article(final String title, final User user, final String context) {
        this.title = title;
        this.user = user;
        this.context = context;
    }

    public static Article newInstance(final String title, final User user, final String context) {
        return  new Article(title, user, context);
    }
}
