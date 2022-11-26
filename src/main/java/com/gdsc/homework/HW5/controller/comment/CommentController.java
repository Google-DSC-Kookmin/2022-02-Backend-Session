package com.gdsc.homework.HW5.controller.comment;

import com.gdsc.homework.HW5.controller.comment.dto.request.CommentRequest;
import com.gdsc.homework.HW5.controller.comment.dto.response.CommentResponse;
import com.gdsc.homework.HW5.service.comment.CommentService;
import com.gdsc.homework.HW5.service.comment.dto.response.CommentServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping(value="/comment", consumes = "application/json")
    public CommentResponse postComment(@RequestBody CommentRequest commentRequest) {
        CommentServiceResponse commentServiceResponse = commentService.save(CommentRequest.toServiceDto(
                commentRequest.getArticleId(),
                commentRequest.getUserId(),
                commentRequest.getContent()
        ));

        return CommentResponse.newInstance(
                commentServiceResponse.getId(),
                commentServiceResponse.getArticleId(),
                commentServiceResponse.getUserId(),
                commentServiceResponse.getContent());
    }

    @GetMapping("/comment/{id}")
    public CommentResponse getComment(@PathVariable Long id) {
        CommentServiceResponse commentServiceResponse = commentService.findById(id);

        return CommentResponse.newInstance(
                commentServiceResponse.getId(),
                commentServiceResponse.getArticleId(),
                commentServiceResponse.getUserId(),
                commentServiceResponse.getContent()
        );
    }
}
