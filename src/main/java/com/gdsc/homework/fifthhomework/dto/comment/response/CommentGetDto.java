package com.gdsc.homework.fifthhomework.dto.comment.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentGetDto {

    private Long id;

    private String comment;

    private String username;

    private Long postId;

}
