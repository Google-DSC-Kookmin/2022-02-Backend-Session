package com.gdsc.homework.HW5.service.comment;

import com.gdsc.homework.HW5.domain.Article;
import com.gdsc.homework.HW5.domain.Comment;
import com.gdsc.homework.HW5.domain.User;
import com.gdsc.homework.HW5.repository.ArticleRepository;
import com.gdsc.homework.HW5.repository.CommentRepository;
import com.gdsc.homework.HW5.repository.UserRepository;
import com.gdsc.homework.HW5.service.comment.dto.request.CommentServiceRequest;
import com.gdsc.homework.HW5.service.comment.dto.response.CommentServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public final CommentServiceResponse save(CommentServiceRequest commentServiceRequest) {
        Optional<Article> optionalArticle = articleRepository.findById(commentServiceRequest.getArticleId());
        validatePresentArticle(optionalArticle);
        Article article = optionalArticle.get();

        Optional<User> optionalUser = userRepository.findById(commentServiceRequest.getUserId());
        validatePresentUser(optionalUser);
        User user = optionalUser.get();

        Comment comment = commentRepository.save(Comment.newInstance(
                article,
                user,
                commentServiceRequest.getContent()
        ));

        return CommentServiceResponse.of(
                comment.getId(),
                article.getId(),
                user.getId(),
                comment.getContent()
        );
    }

    public final CommentServiceResponse findById(Long id) {
        Optional<Comment> optional = commentRepository.findById(id);
        validatePresentComment(optional);
        Comment comment = optional.get();

        return CommentServiceResponse.of(
                comment.getId(),
                comment.getArticle().getId(),
                comment.getUser().getId(),
                comment.getContent()
        );
    }
    private void validatePresentComment(Optional<Comment> optional) {
        if(optional.isEmpty()) {
            throw new IllegalStateException();
        }
    }

    private void validatePresentArticle(Optional<Article> optional) {
        if(optional.isEmpty()){
            throw new IllegalStateException("Article이 존재하지 않습니다.");
        }
    }

    private void validatePresentUser(Optional<User> optional) {
        if(optional.isEmpty()) {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }
    }
}
