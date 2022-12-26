package com.gdsc.homework.service.post.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostServiceModifyRequest {
    private String email;
    private Long id;
    private String title;
    private String content;

    public static PostServiceModifyRequest newInstance(String email, Long id, String title, String content) {
        return new PostServiceModifyRequest(email, id, title, content);
    }
}
