package com.gdsc.homework.fifthhomework.domain.comment;

import com.gdsc.homework.fifthhomework.domain.like.Like;
import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.domain.user.User;
import com.gdsc.homework.fifthhomework.dto.comment.request.CommentUpdateDto;
import com.gdsc.homework.fifthhomework.dto.post.request.PostPostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String comment;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;


    private Comment(String comment, User user, Post post) {
        this.comment = comment;
        this.user = user;
        this.post = post;
    }

    public static Comment newInstance(final String comment, final User user,final Post post){
        return new Comment(comment,user,post);
    }

    public static void updateComment(CommentUpdateDto commentUpdateDto, Comment comment){
        comment.comment = commentUpdateDto.getComment();
    }


}
