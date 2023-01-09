package com.gdsc.homework.controller.comment.dto.request;

import com.gdsc.homework.domain.comment.Comment;
import com.gdsc.homework.service.article.dto.request.ArticleDto;
import com.gdsc.homework.service.comment.dto.request.CommentDto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentRequest {
    @NotBlank
    private String content;
    public CommentDto toServiceDto() {
        return CommentDto.of(content);
    }
}
