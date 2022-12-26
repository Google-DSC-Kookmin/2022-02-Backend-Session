package com.gdsc.homework.firstAssignment.domain.post;

import com.gdsc.homework.firstAssignment.domain.common.BaseTimeEntity;
import com.gdsc.homework.firstAssignment.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Getter
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @Column
    private int likeCount;

    public static Post newInstance(String title, String content, User author) {
        return new Post(title, content, author, 0);
    }

    private Post (String title, String content, User author, int likeCount) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.likeCount = likeCount;
    }

    public Post(){}
}
