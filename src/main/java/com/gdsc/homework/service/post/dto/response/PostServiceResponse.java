package com.gdsc.homework.service.post.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostServiceResponse {
    private Long id;
    private String title;
    private String content;

    public static PostServiceResponse of(Long id, String title, String content) {
        return new PostServiceResponse(id,title, content);
    }
}
