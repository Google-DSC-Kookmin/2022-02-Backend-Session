package com.gdsc.homework.firstAssignment.domain.like;

import com.gdsc.homework.firstAssignment.domain.post.Post;
import com.gdsc.homework.firstAssignment.domain.user.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Like(){}

    private Like(Post post, User user) {
        this.post = post;
        this.user = user;
    }

    public static Like newInstance(Post post, User user) {
        return new Like(post, user);
    }
}
