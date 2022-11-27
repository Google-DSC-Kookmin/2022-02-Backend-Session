package com.gdsc.homework.fifthHW.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    Id;

    @Column
    private String  name;
    @Column
    private String  email;
    @Column
    private String  password;

    private User(final String name, final String email, final String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User newInstance(final String name, final String email, final String password) {
        return  new User(name, email, password);
    }
}
