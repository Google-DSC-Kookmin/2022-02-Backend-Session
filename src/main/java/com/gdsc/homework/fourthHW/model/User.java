package com.gdsc.homework.fourthHW.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue
    private Long userID;
    @Column(name = "USERNAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user")
    List<Likes> likes = new ArrayList<Likes>();
    @OneToMany(mappedBy = "user")
    List<Comment> comments = new ArrayList<Comment>();
}
