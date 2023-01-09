package com.gdsc.homework.controller.comment;

import com.gdsc.homework.config.BaseResponse;
import com.gdsc.homework.controller.comment.dto.request.CommentRequest;
import com.gdsc.homework.domain.comment.Comment;
import com.gdsc.homework.service.comment.CommentService;
import com.gdsc.homework.service.comment.dto.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping(value = "/{articleId}")
    public BaseResponse<CommentResponse> postComment(@PathVariable(value = "articleId", required = true) final Long articleId,
                                                     @RequestBody @Valid final CommentRequest commentRequest) {
        return new BaseResponse<>(commentService.postComment(articleId, commentRequest.toServiceDto()));
    }
    @DeleteMapping(value = "/{commentId}")
    public BaseResponse<String> deleteComment(@PathVariable(value = "commentId", required = true) final Long commentId) {
        return new BaseResponse<>(commentService.deleteComment(commentId));
    }
}
