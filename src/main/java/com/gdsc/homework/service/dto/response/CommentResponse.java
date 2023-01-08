package com.gdsc.homework.service.dto.response;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentResponse {
    private Long commentId;
    private Long userId;
    private Long articleId;
    private String content;

    public static CommentResponse of(Long commentId, Long userId, Long articleId, String content){
        return new CommentResponse(commentId, userId, articleId, content);
    }
}
