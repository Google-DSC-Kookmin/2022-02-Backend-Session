package com.gdsc.homework.fifthhomework.controller;


import com.gdsc.homework.fifthhomework.dto.comment.response.CommentGetDto;
import com.gdsc.homework.fifthhomework.service.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @GetMapping("/comments/{postId}")
    public List<CommentGetDto> getCommentsByPostId(@PathVariable(name = "postId") Long postId){
        return commentService.getComments(postId);
    }

    @GetMapping("/comments/{userId}")
    public List<CommentGetDto> getCommentsByUserId(@PathVariable(name = "userId") Long userId){
        return commentService.getCommentsByUser(userId);
    }
}
