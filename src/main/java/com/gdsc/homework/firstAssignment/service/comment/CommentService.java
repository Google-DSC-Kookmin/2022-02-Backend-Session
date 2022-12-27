package com.gdsc.homework.firstAssignment.service.comment;

import com.gdsc.homework.firstAssignment.controller.comment.dto.CommentWriteReqDto;
import com.gdsc.homework.firstAssignment.domain.comment.Comment;
import com.gdsc.homework.firstAssignment.domain.comment.CommentRepository;
import com.gdsc.homework.firstAssignment.domain.post.Post;
import com.gdsc.homework.firstAssignment.domain.post.PostRepository;
import com.gdsc.homework.firstAssignment.domain.user.User;
import com.gdsc.homework.firstAssignment.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    public void writeComment(final Long postId, final Long userId, CommentWriteReqDto commentWriteReqDto) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 post id 입니다."));
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 user id 입니다."));
        String content = commentWriteReqDto.getContent();
        Comment newComment = Comment.newInstance(post, user, content);
        commentRepository.save(newComment);
    }

    public void deleteComment(final Long postId, final Long userId) {
        commentRepository.deleteCommentByPostIdAndUserId(postId, userId);
    }
}
