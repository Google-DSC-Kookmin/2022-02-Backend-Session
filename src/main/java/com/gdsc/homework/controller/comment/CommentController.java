package com.gdsc.homework.controller.comment;

import com.gdsc.homework.controller.comment.dto.request.CommentRequest;
import com.gdsc.homework.auth.jwt.JwtTokenProvider;
import com.gdsc.homework.service.comment.CommentService;
import com.gdsc.homework.service.comment.dto.request.CommentServiceRequest;
import com.gdsc.homework.service.comment.dto.request.DeleteCommentServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final JwtTokenProvider jwtTokenProvider = JwtTokenProvider.newInstance();
    @PostMapping(value = "/post/{postId}/comment")
    public final Long addComment(@PathVariable("postId") Long postId, CommentRequest commentRequest, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        String email = jwtTokenProvider.generateTokenToEmail(token);
        return commentService.addComment(
                CommentServiceRequest.newInstance(email, postId, commentRequest.getContent())
        );
    }

    @DeleteMapping(value = "/comment/{commentId}")
    public final String deleteComment(@PathVariable("commentId") Long commentId, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        String email = jwtTokenProvider.generateTokenToEmail(token);
        commentService.deleteComment(DeleteCommentServiceRequest.newInstance(email, commentId));
        return "SUCCESS - Delete Comment";
    }
}
