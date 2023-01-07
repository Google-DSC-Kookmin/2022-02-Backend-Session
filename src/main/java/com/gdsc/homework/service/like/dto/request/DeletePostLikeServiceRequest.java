package com.gdsc.homework.service.like.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DeletePostLikeServiceRequest {
    private String email;
    private Long postLikeId;

    public static DeletePostLikeServiceRequest newInstance(String email, Long postLikeId) {
        return new DeletePostLikeServiceRequest(email, postLikeId);
    }
}
