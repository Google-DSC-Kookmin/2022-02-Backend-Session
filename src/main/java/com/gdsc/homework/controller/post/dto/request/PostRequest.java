package com.gdsc.homework.controller.post.dto.request;

import com.gdsc.homework.service.post.dto.request.PostServiceRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PostRequest {
    private String title;
    private String content;

    public static PostServiceRequest toServiceDto(String email, String title, String content) {
        return PostServiceRequest.newInstance(
                email, title, content
        );
    }
}
