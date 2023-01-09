package com.gdsc.homework.service.comment;

import com.gdsc.homework.config.security.JwtService;
import com.gdsc.homework.domain.article.Article;
import com.gdsc.homework.domain.article.ArticleRepository;
import com.gdsc.homework.domain.comment.Comment;
import com.gdsc.homework.domain.comment.CommentRepository;
import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import com.gdsc.homework.service.comment.dto.request.CommentDto;
import com.gdsc.homework.service.comment.dto.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;
    private final JwtService jwtService;
    @Transactional
    public CommentResponse postComment(final Long articleId, final CommentDto commentDto) {
        final Long userId = jwtService.getUserId();
        final User foundUser = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        final Article foundArticle = articleRepository.findArticleByArticleId(articleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        final Comment newComment = Comment.newInstance(commentDto.getContent(), foundUser, foundArticle);
        commentRepository.save(newComment);
        return CommentResponse.newInstance(newComment.getCommentId(), newComment.getUser().getUserId(),
                newComment.getContent(), newComment.getCreatedAt(), newComment.getModifiedAt());
    }


    @Transactional
    public String deleteComment(final Long commentId) {
        final Long userId = jwtService.getUserId();
        final User foundUser = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        final Comment foundComment = commentRepository.findCommentByCommentId(commentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        if (!foundComment.getUser().getUserId().equals(userId)) {
            return "삭제할 수 없는 댓글입니다.";
        }
        commentRepository.deleteById(commentId);
        return "댓글 삭제 완료.";
    }
}
