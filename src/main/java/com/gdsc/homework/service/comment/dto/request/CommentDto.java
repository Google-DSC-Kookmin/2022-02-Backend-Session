package com.gdsc.homework.service.comment.dto.request;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentDto {
    private String content;
    public static CommentDto of(final String content) {
        return new CommentDto(content);
    }
}
