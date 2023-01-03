package com.gdsc.homework.controller;

import com.gdsc.homework.controller.dto.ResponseDTO;
import com.gdsc.homework.controller.dto.request.CommentRequest;
import com.gdsc.homework.controller.dto.response.CommentDTO;
import com.gdsc.homework.service.CommentService;
import com.gdsc.homework.service.dto.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CommentRequest commentRequest){
        try {
            CommentResponse getComment=commentService.save(commentRequest.toServiceDto());
            CommentDTO responseDTO = CommentDTO.of(getComment.getCommentId(), getComment.getUserId(), getComment.getArticleId(), getComment.getContent());
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
    @DeleteMapping("/{commentId}")
    public String delete(@PathVariable Long commentId){
        try {
            commentService.delete(commentId);
            return "delete";
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return responseDTO.getError();
        }
    }

}
