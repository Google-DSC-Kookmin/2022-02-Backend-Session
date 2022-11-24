package com.gdsc.homework.fifthhomework.domain.user;


import com.gdsc.homework.fifthhomework.domain.article.Article;
import com.gdsc.homework.fifthhomework.domain.comment.Comment;
import com.gdsc.homework.thirdstudy.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Userame")
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Comment> comments = new ArrayList<>();

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public static User newInstance(final String name, final String email, final String password){
        return new User(name,email,password);
    }
}
