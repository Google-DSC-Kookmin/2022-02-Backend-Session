package com.gdsc.homework.service.article.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gdsc.homework.domain.comment.Comment;
import com.gdsc.homework.service.comment.dto.response.CommentResponse;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonPropertyOrder({"articleId", "title", "content", "likeCount","createAt", "modifiedAt","comments"})
public class ArticleDetailCommentsResponse {
    private Long articleId;
    private String title;
    private String content;
    private Long likeCount;
    private List<CommentResponse> comments;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public static ArticleDetailCommentsResponse newInstance(final Long articleId, final String title, final String content,
                                                            final Long likeCount, final List<Comment> comments,
                                                            final LocalDateTime createAt, final LocalDateTime modifiedAt) {

        return new ArticleDetailCommentsResponse(articleId, title, content, likeCount,
                comments.stream()
                        .map(c -> CommentResponse.newInstance(
                                c.getCommentId(),
                                c.getUser().getUserId(),
                                c.getContent(),
                                c.getCreatedAt(),
                                c.getModifiedAt()))
                        .collect(Collectors.toList()),createAt, modifiedAt);
    }
}
