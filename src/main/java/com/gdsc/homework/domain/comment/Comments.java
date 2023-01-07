package com.gdsc.homework.domain.comment;

import com.gdsc.homework.domain.post.Posts;
import com.gdsc.homework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "COMMENTS")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Posts posts;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private Comments(String content, Posts posts, User user) {
        this.content = content;
        this.posts = posts;
        this.user = user;
    }

    public static Comments newInstance(String content, Posts posts, User user) {
        return new Comments(content, posts, user);
    }
}
