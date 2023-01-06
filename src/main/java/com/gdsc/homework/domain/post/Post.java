package com.gdsc.homework.domain.post;

import com.gdsc.homework.domain.comment.Comment;
import com.gdsc.homework.domain.like.PostLike;
import com.gdsc.homework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "auther_id")
    private User auther;

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<PostLike> postLikes = new ArrayList<PostLike>();

    @Formula("(SELECT count(1) FROM post_like l WHERE l.post_id = id)")
    private int totalPostLikes;

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments = new ArrayList<Comment>();

    private Post(String title, String content, User auther) {
        this.title = title;
        this.content = content;
        this.auther = auther;
    }
    public static Post newInstance(String title, String content, User auther) {
        return new Post(title, content, auther);
    }

    public void editTitleAndContent(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
