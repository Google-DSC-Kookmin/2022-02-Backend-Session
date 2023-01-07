package com.gdsc.homework.domain.user;

import com.gdsc.homework.domain.post.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "USER")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    @Column(unique = true)
    private String nickname;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "auther")
    private List<Posts> posts = new ArrayList<Posts>();
    private User(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public static User newInstance(String email, String nickname, String password) {
        return new User(email, nickname, password);
    }

    public void changeEmailAndNickname(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
