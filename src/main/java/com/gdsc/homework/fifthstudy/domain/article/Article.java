package com.gdsc.homework.fifthstudy.domain.article;

import com.gdsc.homework.fifthstudy.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name="author_id")
    private User user;

    private Article(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
    public static Article newInstance(final String title, final String content, final User user){
        return new Article(title, content, user);
    }
}
