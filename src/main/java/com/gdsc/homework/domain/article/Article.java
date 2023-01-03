package com.gdsc.homework.domain.article;

import com.gdsc.homework.domain.BaseTimeEntity;
import com.gdsc.homework.domain.comment.Comment;
import com.gdsc.homework.domain.likeArtlcle.LikeArticle;
import com.gdsc.homework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Article extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;
    @Column(name="like_count")
    private int likeCount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "article",orphanRemoval = true)
    List<LikeArticle> likeArticles = new ArrayList<LikeArticle>();

    @OneToMany(mappedBy = "article",orphanRemoval = true)
    List<Comment> comments = new ArrayList<Comment>();
    private Article(String title, String content,User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
    public void like(){
        this.likeCount += 1;
    }
    public void unLike(){
        this.likeCount -= 1;
    }

    public void updateTitleOrContent (String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Article newInstance(final String title, final String content, final User user) {
        return new Article(title, content, user);
    }


}
