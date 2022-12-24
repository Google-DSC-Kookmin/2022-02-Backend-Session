package com.gdsc.homework.fifthhomework.service.comment;

import com.gdsc.homework.fifthhomework.dto.comment.response.CommentGetDto;

import java.util.List;

public interface CommentService {

    List<CommentGetDto> getComments(Long postId);

    List<CommentGetDto> getCommentsByUser(Long userId);
}
