package com.gdsc.homework.HW5.domain;

import lombok.AccessLevel;
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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "auther_id")
    private User user;
    private String title;
    private String content;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments = new ArrayList<Comment>();
    @OneToMany(mappedBy = "article")
    private List<Like> Likes = new ArrayList<Like>();

    private Article(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public static Article newInstance(User user, String title, String content) {
        return new Article(user, title, content);
    }
}
