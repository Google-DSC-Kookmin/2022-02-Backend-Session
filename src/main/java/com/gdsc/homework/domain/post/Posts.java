package com.gdsc.homework.domain.post;

import com.gdsc.homework.domain.BaseTimeEntity;
import com.gdsc.homework.domain.comment.Comments;
import com.gdsc.homework.domain.like.PostLikes;
import com.gdsc.homework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "POSTS")
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "auther_id")
    private User auther;

    @OneToMany(mappedBy = "posts", orphanRemoval = true)
    private List<PostLikes> postLikes = new ArrayList<PostLikes>();

    @Formula("(SELECT count(1) FROM postlikes l WHERE l.post_id = id)")
    private int totalPostLikes;

    @OneToMany(mappedBy = "posts", orphanRemoval = true)
    private List<Comments> comments = new ArrayList<Comments>();

    private Posts(String title, String content, User auther) {
        this.title = title;
        this.content = content;
        this.auther = auther;
    }
    public static Posts newInstance(String title, String content, User auther) {
        return new Posts(title, content, auther);
    }

    public void editTitleAndContent(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
