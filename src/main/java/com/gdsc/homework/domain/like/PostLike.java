package com.gdsc.homework.domain.like;

import com.gdsc.homework.domain.post.Post;
import com.gdsc.homework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private PostLike(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public static PostLike newInstance(User user, Post post) {
        return new PostLike(user, post);
    }


}
