package com.gdsc.homework.firstAssignment.controller.post;

import com.gdsc.homework.firstAssignment.controller.post.dto.PostModifyReqDto;
import com.gdsc.homework.firstAssignment.controller.post.dto.PostWriteReqDto;
import com.gdsc.homework.firstAssignment.service.post.PostService;
import com.gdsc.homework.firstAssignment.service.post.dto.PostListResDto;
import com.gdsc.homework.firstAssignment.service.post.dto.PostResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post/{userId}")
    public PostResDto writePost(@PathVariable final Long userId, PostWriteReqDto postWriteReqDto) {
        return postService.writePost(userId, postWriteReqDto);
    }

    @PutMapping("/post/{postId}")
    public PostResDto modifyPost(@PathVariable final Long postId, PostModifyReqDto postModifyReqDto) {
        return postService.modifyPost(postId, postModifyReqDto);
    }

    @DeleteMapping("/post/{postId}")
    public void deletePost(@PathVariable final Long postId){
        postService.deletePost(postId);
    }

    @GetMapping("/post/recent")
    public PostListResDto getRecentPost(){
        return postService.getRecentPost();
    }

    @GetMapping("/post/most-liked")
    public PostListResDto getMostLikedPost() {
        return postService.getMostLikedPost();
    }
}
