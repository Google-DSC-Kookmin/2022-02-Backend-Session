package com.gdsc.homework.firstAssignment.domain.user;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column
    private String email;

    @Column
    private String nickname;

    public static User newInstance(String email, String nickname) {
        return new User(email, nickname);
    }

    private User (String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public User(){}
}
