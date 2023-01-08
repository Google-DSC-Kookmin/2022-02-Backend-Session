package com.gdsc.homework.service.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentDTO {
    private Long userId;
    private Long articleId;
    private String content;

    public static CommentDTO of(Long userId, Long articleId, String content) {
        return new CommentDTO(userId, articleId, content);
    }
}
