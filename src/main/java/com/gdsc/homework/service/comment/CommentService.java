package com.gdsc.homework.service.comment;

import com.gdsc.homework.domain.comment.Comment;
import com.gdsc.homework.domain.comment.CommentRepository;
import com.gdsc.homework.domain.post.Post;
import com.gdsc.homework.domain.post.PostRepository;
import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import com.gdsc.homework.service.comment.dto.request.CommentServiceRequest;
import com.gdsc.homework.service.comment.dto.request.DeleteCommentServiceRequest;
import com.gdsc.homework.validAPI.PostValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PostValidation postValidation;

    public final Long addComment(CommentServiceRequest commentServiceRequest) {
        postValidation.presentPost(commentServiceRequest.getPostId());
        User user = userRepository.findByEmail(commentServiceRequest.getEmail()).get();
        Post post = postRepository.findById(commentServiceRequest.getPostId()).get();

        return commentRepository.save(Comment.newInstance(
                commentServiceRequest.getContent(),
                post,
                user
        )).getId();
    }

    public final void deleteComment(DeleteCommentServiceRequest deleteCommentServiceRequest) {
        validateComment(deleteCommentServiceRequest.getCommentId());
        Comment comment = commentRepository.findById(deleteCommentServiceRequest.getCommentId()).get();
        validateCommentWithUser(deleteCommentServiceRequest.getEmail(), comment);
        commentRepository.deleteById(deleteCommentServiceRequest.getCommentId());
    }

    private void validateComment(Long commentId) {
        if(commentRepository.findById(commentId).isEmpty()) {
            throw new IllegalArgumentException("Comment Id가 존재하지 않음");
        }
    }

    private void validateCommentWithUser(String email, Comment comment) {
        if(!comment.getUser().getEmail().equals(email)) {
            throw new IllegalArgumentException("해당 유저가 댓글을 단 것이 아닙니다.");
        }
    }
}
