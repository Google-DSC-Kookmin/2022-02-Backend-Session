package com.gdsc.homework.controller.like;

import com.gdsc.homework.jwt.JwtTokenProvider;
import com.gdsc.homework.service.like.PostLikeService;
import com.gdsc.homework.service.like.dto.request.PostLikeServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class PostLikeController {
    private final PostLikeService postLikeService;
    private final JwtTokenProvider jwtTokenProvider = JwtTokenProvider.newInstance();

    @PostMapping(value = "/post/{postId}/like")
    public final Long like(@PathVariable("postId") Long postId, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        String email = jwtTokenProvider.generateTokenToEmail(token);

        return postLikeService.addLike(PostLikeServiceRequest.newInstance(
           email, postId
        ));
    }

    @DeleteMapping(value = "/postlike/{postLikeId}")
    public final String unlike(@PathVariable("postLikeId") Long postLikeId) {
        postLikeService.deleteLike(postLikeId);
        return "SUCCESS - PostLike cancel";
    }
}
