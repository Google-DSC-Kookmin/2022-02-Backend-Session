package com.gdsc.homework.firstAssignment.domain.comment;

import com.gdsc.homework.firstAssignment.domain.common.BaseTimeEntity;
import com.gdsc.homework.firstAssignment.domain.post.Post;
import com.gdsc.homework.firstAssignment.domain.user.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column
    private String content;

    public Comment(){}

    private Comment(Post post, User author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
    }

    public static Comment newInstance(Post post, User author, String content) {
        return new Comment(post, author, content);
    }
}
