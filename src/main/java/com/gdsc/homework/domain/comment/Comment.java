package com.gdsc.homework.domain.comment;

import com.gdsc.homework.domain.post.Post;
import com.gdsc.homework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private Comment(String content, Post post, User user) {
        this.content = content;
        this.post = post;
        this.user = user;
    }

    public static Comment newInstance(String content, Post post, User user) {
        return new Comment(content, post, user);
    }
}
