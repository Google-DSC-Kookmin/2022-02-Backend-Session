package com.gdsc.homework.controller.post;

import com.gdsc.homework.controller.post.dto.request.PostModifyRequest;
import com.gdsc.homework.controller.post.dto.request.PostRequest;
import com.gdsc.homework.controller.post.dto.response.PostResponse;
import com.gdsc.homework.jwt.JwtTokenProvider;
import com.gdsc.homework.service.post.PostService;
import com.gdsc.homework.service.post.dto.request.PostServiceRequest;
import com.gdsc.homework.service.post.dto.response.PostServiceResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JwtTokenProvider jwtTokenProvider = JwtTokenProvider.newInstance();

    @PostMapping(value = "/post", consumes = "application/json")
    public final Long upload(@RequestBody PostRequest postRequest, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        String email = generateTokenToEmail(token);

        return postService.uploadPost(PostRequest.toServiceDto(
                email,
                postRequest.getTitle(),
                postRequest.getContent()
        ));
    }

    @PatchMapping(value = "/post", consumes = "application/json")
    public final String modifyPost(@RequestBody PostModifyRequest postModifyRequest, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        String email = generateTokenToEmail(token);
        postService.modifyPost(PostModifyRequest.toServiceDto(
                email,
                postModifyRequest.getId(),
                postModifyRequest.getTitle(),
                postModifyRequest.getContent()
        ));
        return "Success";
    }

    @GetMapping(value = "/post/{id}")
    public final PostResponse findById(@PathVariable Long id) {
        logger.info("Get Post {}", id);
        PostServiceResponse postServiceResponse = postService.findById(id);
        return PostResponse.newInstance(
                postServiceResponse.getId(),
                postServiceResponse.getTitle(),
                postServiceResponse.getContent()
        );
    }

    private String generateTokenToEmail(String token) {
        try {
            String email = jwtTokenProvider.validateJwt(token).get("sub").toString();
            return email;
        } catch (Exception e) {
            throw new IllegalArgumentException("토큰 에러");
        }
    }
}
