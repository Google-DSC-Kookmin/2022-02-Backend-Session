package com.gdsc.homework.service.post.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DeletePostServiceRequest {
    private String email;
    private Long postId;

    public static  DeletePostServiceRequest newInstance(String email, Long postId) {
        return new DeletePostServiceRequest(email, postId);
    }
}
