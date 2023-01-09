package com.gdsc.homework.domain.user;

import com.gdsc.homework.domain.base.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column
    private String email;
    @Column
    private String nickname;

    public User(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public void updateUserEmail(String newEmail) {
        this.email = newEmail;
    }
    public void updateUserNickname(String newNickname) {
        this.nickname = newNickname;
    }
    public static User newInstance(final String email, final String nickname) {
        return new User(email, nickname);
    }

}
