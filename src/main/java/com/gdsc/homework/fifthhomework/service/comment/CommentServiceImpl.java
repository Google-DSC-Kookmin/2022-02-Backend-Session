package com.gdsc.homework.fifthhomework.service.comment;


import com.gdsc.homework.fifthhomework.domain.comment.Comment;
import com.gdsc.homework.fifthhomework.domain.comment.CommentRepository;
import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.domain.post.PostRepository;
import com.gdsc.homework.fifthhomework.domain.user.User;
import com.gdsc.homework.fifthhomework.domain.user.UserRepository;
import com.gdsc.homework.fifthhomework.dto.comment.request.CommentUpdateDto;
import com.gdsc.homework.fifthhomework.dto.comment.response.CommentGetDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    
    private final PostRepository postRepository;

    private final UserRepository userRepository;


    @Transactional
    @Override
    public List<CommentGetDto> getComments(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new IllegalArgumentException("없는 게시물입니다."));
        List<Comment> byPost = commentRepository.findByPost(post);
        List<CommentGetDto> commentGetDtos = new ArrayList<>();
        for (Comment comment : byPost) {
            CommentGetDto commentGetDto = new CommentGetDto();
            commentGetDto.setId(comment.getId());
            commentGetDto.setComment(comment.getComment());
            commentGetDto.setUsername(comment.getUser().getNickname());
            commentGetDto.setPostId(postId);
            commentGetDtos.add(commentGetDto);
        }
        return commentGetDtos;
    }

    @Transactional
    @Override
    public List<CommentGetDto> getCommentsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("없는 사용자입니다."));
        List<Comment> byUser = commentRepository.findByUser(user);
        List<CommentGetDto>commentGetDtos = new ArrayList<>();
        for (Comment comment: byUser) {
            CommentGetDto commentGetDto = new CommentGetDto();
            commentGetDto.setId(comment.getId());
            commentGetDto.setComment(comment.getComment());
            commentGetDto.setUsername(comment.getUser().getNickname());
            commentGetDto.setPostId(comment.getPost().getId());

        }
        return commentGetDtos;
    }

    @Transactional
    @Override
    public void updateComment(Long commentId, CommentUpdateDto commentUpdateDto) {
        User user = checkUser(commentUpdateDto);
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new IllegalArgumentException("없는 댓글입니다."));
        if(comment.getUser()!=user){
            throw new IllegalArgumentException("사용자와 맞지 않습니다.");
        }
        Comment.updateComment(commentUpdateDto,comment);
    }


    @Transactional
    @Override
    public void deleteComment(Long commentId, String email) {
        User user = checkUser(email);
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new IllegalArgumentException("없는 댓글입니다."));
        if(comment.getUser()!=user){
            throw new IllegalArgumentException("사용자와 맞지 않습니다.");
        }
        commentRepository.delete(comment);
    }
    private User checkUser(CommentUpdateDto commentUpdateDto) {
        User user = userRepository.findByEmail(commentUpdateDto.getUserEmail())
                .orElseThrow(()-> new IllegalArgumentException("없는 사용자입니다."));
        return user;
    }

    private User checkUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException("없는 사용자입니다."));
        return user;
    }
}
