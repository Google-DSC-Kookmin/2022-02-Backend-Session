package com.gdsc.homework.fifthHw.domain.user;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class User {
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;
}
