package com.gdsc.homework.fifthhomework.domain.article;


import com.gdsc.homework.fifthhomework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column
    private String title;

    @Column
    private String content;

    public Article(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public static Article newInstance(final User user, final String title, final String content){
        return new Article(user,title,content);
    }
}
