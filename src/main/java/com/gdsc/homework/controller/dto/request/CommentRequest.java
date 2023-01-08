package com.gdsc.homework.controller.dto.request;

import com.gdsc.homework.service.dto.request.CommentDTO;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentRequest {
    private Long commentId;
    private Long userId;
    private Long articleId;
    private String content;

    public CommentDTO toServiceDto() {
        return CommentDTO.of(userId, articleId, content);
    }
}
