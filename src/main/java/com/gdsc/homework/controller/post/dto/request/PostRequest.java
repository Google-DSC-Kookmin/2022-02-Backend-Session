package com.gdsc.homework.controller.post.dto.request;

import com.gdsc.homework.service.post.dto.request.PostServiceRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PostRequest {
    @NotBlank
    private String title;
    @NotNull
    private String content;

    public static PostServiceRequest toServiceDto(String email, String title, String content) {
        return PostServiceRequest.newInstance(
                email, title, content
        );
    }
}
