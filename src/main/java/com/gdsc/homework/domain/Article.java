package com.gdsc.homework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Article extends BaseTimeEntity{
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

    @OneToMany(mappedBy = "article")
    List<LikeArticle> likeArticles = new ArrayList<LikeArticle>();

    public Article(String title, String content,User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Article(Long articleId, String title, String content, int likeCount) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
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

    @OneToMany(mappedBy = "article")
    List<Comment> comments = new ArrayList<Comment>();
    public static Article newInstance(final String title, final String content, final User user) {
        return new Article(title, content, user);
    }


}
