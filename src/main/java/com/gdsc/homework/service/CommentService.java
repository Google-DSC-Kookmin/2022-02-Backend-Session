package com.gdsc.homework.service;

import com.gdsc.homework.domain.Article;
import com.gdsc.homework.domain.Comment;
import com.gdsc.homework.domain.User;
import com.gdsc.homework.repository.CommentRepository;
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
        log.warn("asdfadfads"+commentDTO.getUserId().toString());
        User getUser = userService.getUser(commentDTO.getUserId());
        Article getArticle = articleService.getArtcle(commentDTO.getArticleId());
        Comment savedCommnet =commentRepository.save(Comment.newInstance(commentDTO.getContent(), getUser, getArticle));
        return CommentResponse.of(savedCommnet.getCommentId(), savedCommnet.getUser().getUserID(), savedCommnet.getArticle().getArticleId(), savedCommnet.getContent());
    }
}
