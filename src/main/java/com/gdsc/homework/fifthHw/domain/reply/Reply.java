package com.gdsc.homework.fifthHw.domain.reply;

import com.gdsc.homework.fifthHw.domain.comment.Comment;
import com.gdsc.homework.fifthHw.domain.user.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Column
    private String content;
}
