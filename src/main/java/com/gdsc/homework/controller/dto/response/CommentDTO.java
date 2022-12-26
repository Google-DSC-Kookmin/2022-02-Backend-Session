package com.gdsc.homework.controller.dto.response;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentDTO {
    private Long commentId;
    private Long userId;
    private Long articleId;
    private String content;
    public static CommentDTO of(Long commentId, Long userId, Long articleId, String content){
        return new CommentDTO(commentId, userId, articleId, content);
    }
}
