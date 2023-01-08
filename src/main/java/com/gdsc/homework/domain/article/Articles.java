package com.gdsc.homework.domain.article;

import com.gdsc.homework.domain.BaseTimeEntity;
import com.gdsc.homework.domain.comment.Comments;
import com.gdsc.homework.domain.likeArtlcle.Likes;
import com.gdsc.homework.domain.user.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "articles")
@NoArgsConstructor
public class Articles extends BaseTimeEntity {
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
    Users users;

    @OneToMany(mappedBy = "articles",orphanRemoval = true)
    List<Likes> likes = new ArrayList<Likes>();

    @OneToMany(mappedBy = "articles",orphanRemoval = true)
    List<Comments> comments = new ArrayList<Comments>();
    private Articles(String title, String content, Users users) {
        this.title = title;
        this.content = content;
        this.users = users;
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

    public static Articles newInstance(final String title, final String content, final Users users) {
        return new Articles(title, content, users);
    }


}
