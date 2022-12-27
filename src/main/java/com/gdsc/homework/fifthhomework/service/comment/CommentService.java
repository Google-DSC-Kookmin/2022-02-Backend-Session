package com.gdsc.homework.fifthhomework.service.comment;

import com.gdsc.homework.fifthhomework.dto.comment.request.CommentUpdateDto;
import com.gdsc.homework.fifthhomework.dto.comment.response.CommentGetDto;

import java.util.List;

public interface CommentService {

    List<CommentGetDto> getComments(Long postId);

    List<CommentGetDto> getCommentsByUser(Long userId);

    void updateComment(Long commentId, CommentUpdateDto commentUpdateDto);

    void deleteComment(Long commentId, String email);

}
