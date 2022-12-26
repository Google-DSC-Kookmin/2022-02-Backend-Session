package com.gdsc.homework.domain.post;

import com.gdsc.homework.domain.like.PostLike;
import com.gdsc.homework.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private Post(String title, String content, User auther) {
        this.title = title;
        this.content = content;
        this.auther = auther;
    }
    public static Post newInstance(String title, String content, User auther) {
        return new Post(title, content, auther);
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }

//    @OneToMany(mappedBy = "postlike")
//    private List<PostLike> postLikes = new ArrayList<PostLike>();

}
