package com.gdsc.homework.fifthhomework.service.comment;


import com.gdsc.homework.fifthhomework.domain.comment.Comment;
import com.gdsc.homework.fifthhomework.domain.comment.CommentRepository;
import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.domain.post.PostRepository;
import com.gdsc.homework.fifthhomework.domain.user.User;
import com.gdsc.homework.fifthhomework.domain.user.UserRepository;
import com.gdsc.homework.fifthhomework.dto.comment.response.CommentGetDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    
    private final PostRepository postRepository;

    private final UserRepository userRepository;


    @Override
    public List<CommentGetDto> getComments(Long postId) {
        Post byId = postRepository.findById(postId)
                .orElseThrow(()->new IllegalArgumentException("없는 게시물입니다."));
        List<Comment> byPost = commentRepository.findByPost(byId);
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

    @Override
    public List<CommentGetDto> getCommentsByUser(Long userId) {
        User byId = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("없는 사용자입니다."));
        List<Comment> byUser = commentRepository.findByUser(byId);
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
}
