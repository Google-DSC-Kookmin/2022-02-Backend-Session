package com.gdsc.homework.fifthhomework.controller;


import com.gdsc.homework.fifthhomework.dto.comment.request.CommentUpdateDto;
import com.gdsc.homework.fifthhomework.dto.comment.response.CommentGetDto;
import com.gdsc.homework.fifthhomework.service.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;


    // 포스트에 달린 댓글 조회
    @GetMapping("/comments/{postId}")
    public List<CommentGetDto> getCommentsByPostId(@PathVariable(name = "postId") Long postId){
        return commentService.getComments(postId);
    }

    // 마이페이지 댓글 조회
    @GetMapping("/comments/{userId}")
    public List<CommentGetDto> getCommentsByUserId(@PathVariable(name = "userId") Long userId){
        return commentService.getCommentsByUser(userId);
    }
    // 포스트에서? 댓글 수정
    @PutMapping("/comments/{commentId}")
    public String updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateDto commentUpdateDto){
        commentService.updateComment(commentId, commentUpdateDto );
        return "ok";
    }

    // 포스트에서? 댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable Long commentId, @RequestBody String email){
        commentService.deleteComment(commentId,email);
        return "ok";
    }

}
