package com.gdsc.homework.HW5.service.comment.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentServiceRequest {
    private Long articleId;
    private Long userId;
    private String content;

    public static CommentServiceRequest newInstance(Long articleId, Long userId, String content) {
        return new CommentServiceRequest(articleId, userId, content);
    }
}
