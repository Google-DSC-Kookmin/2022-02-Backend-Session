package com.gdsc.homework.fifthHW.domain;

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
    private Long userId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "user")
    List<Liked> likes = new ArrayList<Liked>();
}
