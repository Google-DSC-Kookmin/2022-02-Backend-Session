package com.gdsc.homework.domain.user;

import com.gdsc.homework.domain.BaseTimeEntity;
import com.gdsc.homework.domain.article.Article;
import com.gdsc.homework.domain.comment.Comment;
import com.gdsc.homework.domain.likeArtlcle.LikeArticle;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(name="nickname")
    private String nickName;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "user")
    List<Article> articles = new ArrayList<Article>();

    @OneToMany(mappedBy = "user")
    List<LikeArticle> likeArticles = new ArrayList<LikeArticle>();

    @OneToMany(mappedBy = "user")
    List<Comment> comments = new ArrayList<Comment>();

    private User(String nickName, String email, String password) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }
    public void updateUser(String nickName, String email){
        this.nickName = nickName;
        this.email = email;
    }

    public static User newInstance(final String nickName, final String email, final String password ){
        return new User(nickName, email, password);
    }
}
