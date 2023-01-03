package com.gdsc.homework.service;

import com.gdsc.homework.domain.article.Article;
import com.gdsc.homework.domain.comment.Comment;
import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.comment.CommentRepository;
import com.gdsc.homework.service.dto.request.CommentDTO;
import com.gdsc.homework.service.dto.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ArticleService articleService;
    public CommentResponse save(CommentDTO commentDTO) {
        User getUser = userService.getUser(commentDTO.getUserId());
        Article getArticle = articleService.getArtcle(commentDTO.getArticleId());
        Comment savedCommnet =commentRepository.save(Comment.newInstance(commentDTO.getContent(), getUser, getArticle));
        return CommentResponse.of(savedCommnet.getCommentId(), savedCommnet.getUser().getUserID(), savedCommnet.getArticle().getArticleId(), savedCommnet.getContent());
    }

    public void delete(Long commentId) {
        Comment foundComment = getComment(commentId);
        commentRepository.delete(foundComment);
    }
    private Comment getComment(Long commentId){
        Comment foundComment = commentRepository.findByCommentId(commentId)
                .orElseThrow(() -> new IllegalArgumentException("없는 댓글입니다"));
        return foundComment;
    }
}
