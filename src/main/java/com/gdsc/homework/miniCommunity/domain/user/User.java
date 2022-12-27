package com.gdsc.homework.miniCommunity.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String email;

    @Column
    private String nickname;

    private User(final String email, final String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public static User newInstance(final String email, final String nickname){
        return new User(email, nickname);
    }
}
