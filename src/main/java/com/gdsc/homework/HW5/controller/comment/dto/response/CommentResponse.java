package com.gdsc.homework.HW5.controller.comment.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentResponse {
    private Long id;
    private Long articleId;
    private Long userId;
    private String content;

    public static CommentResponse newInstance(Long id, Long articleId, Long userId, String content) {
        return new CommentResponse(id, articleId, userId, content);
    }
}
