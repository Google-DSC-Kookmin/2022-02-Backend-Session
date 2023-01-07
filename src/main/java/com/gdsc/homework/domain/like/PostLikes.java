package com.gdsc.homework.domain.like;

import com.gdsc.homework.domain.post.Posts;
import com.gdsc.homework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "POSTLIKES")
public class PostLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts posts;

    private PostLikes(User user, Posts posts) {
        this.user = user;
        this.posts = posts;
    }

    public static PostLikes newInstance(User user, Posts posts) {
        return new PostLikes(user, posts);
    }


}
