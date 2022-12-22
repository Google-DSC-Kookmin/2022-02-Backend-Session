package com.gdsc.homework.fifthhomework.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String email;

    @Column
    private String nickname;

    @Column
    private String password;

    private User( String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }


    public static User newInstance(final String email, final String nickname, final String password){
        return new User(email,nickname,password);
    }

}
