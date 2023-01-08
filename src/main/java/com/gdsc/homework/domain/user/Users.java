package com.gdsc.homework.domain.user;

import com.gdsc.homework.domain.BaseTimeEntity;
import com.gdsc.homework.domain.article.Articles;
import com.gdsc.homework.domain.comment.Comments;
import com.gdsc.homework.domain.likeArtlcle.Likes;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class Users extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(name="nickname")
    private String nickName;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "users")
    List<Articles> articles = new ArrayList<Articles>();

    @OneToMany(mappedBy = "users")
    List<Likes> likes = new ArrayList<Likes>();

    @OneToMany(mappedBy = "users")
    List<Comments> comments = new ArrayList<Comments>();

    private Users(String nickName, String email, String password) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }
    public void updateUser(String nickName, String email){
        this.nickName = nickName;
        this.email = email;
    }

    public static Users newInstance(final String nickName, final String email, final String password ){
        return new Users(nickName, email, password);
    }
}
