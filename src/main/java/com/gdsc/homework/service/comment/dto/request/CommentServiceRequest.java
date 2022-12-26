package com.gdsc.homework.service.comment.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentServiceRequest {
    private String email;
    private Long postId;
    private String content;

    public static CommentServiceRequest newInstance(String email, Long postId, String content) {
        return new CommentServiceRequest(email, postId, content);
    }
}
