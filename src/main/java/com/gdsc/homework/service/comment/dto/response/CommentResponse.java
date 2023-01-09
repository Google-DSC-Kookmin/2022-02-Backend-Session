package com.gdsc.homework.service.comment.dto.response;

import com.gdsc.homework.service.article.dto.response.ArticleResponse;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentResponse {
    private Long commentId;
    private Long userId;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public static CommentResponse newInstance(final Long commentId, final Long userId,
                                              final String content, final LocalDateTime createAt,
                                              final LocalDateTime modifiedAt) {
        return new CommentResponse(commentId, userId, content, createAt, modifiedAt);
    }
}
