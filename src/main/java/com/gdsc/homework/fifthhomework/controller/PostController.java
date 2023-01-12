package com.gdsc.homework.fifthhomework.controller;


import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.dto.post.request.PostPostDto;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByIdDescDto;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByLikesDto;
import com.gdsc.homework.fifthhomework.service.post.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/") // 메인페이지
    public List<PostsOrderByIdDescDto> getPosts(){
        return postService.getPostsMain();
    }

    @GetMapping("/posts/likes")
    public List<PostsOrderByLikesDto> getPostsOrderByLike(){
        return postService.getPostsOrderByLike();
    }

    @PostMapping("/post")
    public String post(@RequestBody PostPostDto postPostDto){
        postService.postPost(postPostDto);
        return "ok";
    }
    @PutMapping("/post/{postId}")
    public String postUpdate(@RequestBody PostPostDto postPostDto, @PathVariable Long postId){
        postService.postUpdate(postPostDto,postId);
        return "ok";
    }
    @DeleteMapping("/post/{postId}")
    public String postDelete(@PathVariable Long postId){
        postService.postDelete(postId);
        return "ok";
    }
}
