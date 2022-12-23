package com.gdsc.homework.fifthhomework.controller;


import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByIdDescDto;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByLikesDto;
import com.gdsc.homework.fifthhomework.service.post.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public List<PostsOrderByIdDescDto> getPosts(){
        return postService.getPostsMain();
    }

    @GetMapping("/")
    public List<PostsOrderByLikesDto> getPostsOrderByLike(){
        return postService.getPostsOrderByLike();
    }
}
