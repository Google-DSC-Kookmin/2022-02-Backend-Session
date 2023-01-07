package com.gdsc.homework.service.comment;

import com.gdsc.homework.domain.comment.Comments;
import com.gdsc.homework.domain.comment.CommentRepository;
import com.gdsc.homework.domain.post.Posts;
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

    public final Long addComment(final CommentServiceRequest commentServiceRequest) {
        postValidation.presentPost(commentServiceRequest.getPostId());
        final User user = userRepository.findByEmail(commentServiceRequest.getEmail()).get();
        final Posts posts = postRepository.findById(commentServiceRequest.getPostId()).get();

        return commentRepository.save(Comments.newInstance(
                commentServiceRequest.getContent(),
                posts,
                user
        )).getId();
    }

    public final void deleteComment(final DeleteCommentServiceRequest deleteCommentServiceRequest) {
        Comments comments = commentRepository.findById(deleteCommentServiceRequest.getCommentId()).orElseThrow(
                ()->new IllegalArgumentException("Comment Id가 존재하지 않음")
        );
        validateCommentWithUser(deleteCommentServiceRequest.getEmail(), comments);
        commentRepository.deleteById(deleteCommentServiceRequest.getCommentId());
    }

    private void validateCommentWithUser(final String email, final Comments comments) {
        if(!comments.getUser().getEmail().equals(email)) {
            throw new IllegalArgumentException("해당 유저가 댓글을 단 것이 아닙니다.");
        }
    }
}
