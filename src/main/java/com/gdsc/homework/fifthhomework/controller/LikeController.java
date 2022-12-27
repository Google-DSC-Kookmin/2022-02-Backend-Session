package com.gdsc.homework.fifthhomework.controller;


import com.gdsc.homework.fifthhomework.dto.like.response.LikeRequestDto;
import com.gdsc.homework.fifthhomework.dto.like.response.LikeResponseDto;
import com.gdsc.homework.fifthhomework.service.like.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @GetMapping("/like/{postId}")
    public LikeResponseDto getIsLikeAndCountLikes(@PathVariable Long postId, @RequestBody LikeRequestDto likeRequestDto){
        String email = likeRequestDto.getEmail();
        return likeService.getLike(postId,email);
    }

    @PostMapping("/like/{postId}")
    public String postIsLike(@PathVariable Long postId,@RequestBody LikeRequestDto likeRequestDto){
        String email = likeRequestDto.getEmail();
        likeService.postLike(postId,email);
        return "ok";
    }
}
