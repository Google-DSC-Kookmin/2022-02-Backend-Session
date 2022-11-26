package com.gdsc.homework.HW5.controller.comment.dto.request;

import com.gdsc.homework.HW5.service.comment.dto.request.CommentServiceRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CommentRequest {
    Long articleId;
    Long userId;
    String content;

    public static CommentServiceRequest toServiceDto(Long articleId, Long userId, String content) {
        return CommentServiceRequest.newInstance(
                articleId,
                userId,
                content
        );
    }
}
