package com.gdsc.homework.firstAssignment.controller.like;

import com.gdsc.homework.firstAssignment.service.like.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/post/{postId}/{userId}/like")
    public void likePost(@PathVariable final Long postId, @PathVariable final Long userId) {
        likeService.likePost(postId, userId);
    }

    @DeleteMapping("/post/{postId}/{userId}/like")
    public void deletePost(@PathVariable final Long postId, @PathVariable final Long userId) {
        likeService.deletePost(postId, userId);
    }
}
