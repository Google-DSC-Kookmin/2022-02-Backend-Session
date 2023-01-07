package com.gdsc.homework.service.like.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostLikeServiceRequest {
    private String email;
    private Long postId;

    public static PostLikeServiceRequest newInstance(String email, Long postId) {
        return new PostLikeServiceRequest(email, postId);
    }
}
