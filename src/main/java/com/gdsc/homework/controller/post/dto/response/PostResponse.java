package com.gdsc.homework.controller.post.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponse {
    private Long id;
    private String content;
    private String title;

    public static PostResponse newInstance(Long id, String content, String title) {
        return new PostResponse(id, content, title);
    }
}
