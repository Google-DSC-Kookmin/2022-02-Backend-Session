package com.gdsc.homework.HW5.service.comment.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentServiceResponse {
    private Long id;
    private Long articleId;
    private Long userId;
    private String content;

    public static CommentServiceResponse of(Long id, Long articleId, Long userId, String content) {
        return new CommentServiceResponse(id, articleId, userId, content);
    }
}
