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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Article> articles = new ArrayList<Article>();

    private User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User newInstance(String name, String email, String password) {
        return new User(name, email, password);
    }
}
