package com.gdsc.homework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String nickname;

    private User(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public static User newInstance(String email, String nickname) {
        return new User(email, nickname);
    }
}
