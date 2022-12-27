package com.gdsc.homework.firstAssignment.controller.comment;

import com.gdsc.homework.firstAssignment.controller.comment.dto.CommentWriteReqDto;
import com.gdsc.homework.firstAssignment.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/post/{postId}/{userId}/comment")
    public void WriteComment(@PathVariable final Long postId, @PathVariable final Long userId, CommentWriteReqDto commentWriteReqDto) {
        commentService.writeComment(postId, userId, commentWriteReqDto);
    }

    @DeleteMapping("/post/{postId}/{userId}/comment")
    public void deleteComment(@PathVariable final Long postId, @PathVariable final Long userId) {
        commentService.deleteComment(postId, userId);
    }
}
