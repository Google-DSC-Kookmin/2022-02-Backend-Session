package com.gdsc.homework.service.post.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostServiceRequest {
    private String email;
    private String title;
    private String content;

    public static PostServiceRequest newInstance(String email, String title, String content) {
        return new PostServiceRequest(email, title, content);
    }
}
