package com.gdsc.homework.service;

import com.gdsc.homework.domain.article.Articles;
import com.gdsc.homework.domain.comment.Comments;
import com.gdsc.homework.domain.user.Users;
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
        Users getUsers = userService.getUser(commentDTO.getUserId());
        Articles getArticles = articleService.getArtcle(commentDTO.getArticleId());
        Comments savedCommnet =commentRepository.save(Comments.newInstance(commentDTO.getContent(), getUsers, getArticles));
        return CommentResponse.of(savedCommnet.getCommentId(), savedCommnet.getUsers().getUserID(), savedCommnet.getArticles().getArticleId(), savedCommnet.getContent());
    }

    public void delete(Long commentId) {
        Comments foundComments = getComment(commentId);
        commentRepository.delete(foundComments);
    }
    private Comments getComment(Long commentId){
        Comments foundComments = commentRepository.findByCommentId(commentId)
                .orElseThrow(() -> new IllegalArgumentException("없는 댓글입니다"));
        return foundComments;
    }
}
