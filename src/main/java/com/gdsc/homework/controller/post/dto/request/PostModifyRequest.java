package com.gdsc.homework.controller.post.dto.request;

import com.gdsc.homework.service.post.dto.request.PostServiceModifyRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PostModifyRequest {
    private Long id;
    private String title;
    private String content;

    public static PostServiceModifyRequest toServiceDto(String email, Long id, String title, String content) {
        return PostServiceModifyRequest.newInstance(email, id, title, content);
    }
}
