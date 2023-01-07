package com.gdsc.homework.service.comment.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteCommentServiceRequest {
    private String email;
    private Long commentId;

    public static DeleteCommentServiceRequest newInstance(String email, Long commentId) {
        return new DeleteCommentServiceRequest(email, commentId);
    }
}
