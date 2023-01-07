package com.gdsc.homework.controller.post;

import com.gdsc.homework.controller.post.dto.request.PostModifyRequest;
import com.gdsc.homework.controller.post.dto.request.PostRequest;
import com.gdsc.homework.controller.post.dto.response.PostResponse;
import com.gdsc.homework.auth.jwt.JwtTokenProvider;
import com.gdsc.homework.service.post.PostService;
import com.gdsc.homework.service.post.dto.request.DeletePostServiceRequest;
import com.gdsc.homework.service.post.dto.response.PostServiceResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JwtTokenProvider jwtTokenProvider = JwtTokenProvider.newInstance();

    @PostMapping(consumes = "application/json")
    public final Long upload(@RequestBody @Valid final PostRequest postRequest, final HttpServletRequest httpServletRequest) {
        final String token = httpServletRequest.getHeader("Authorization");
        final String email = jwtTokenProvider.generateTokenToEmail(token);

        return postService.uploadPost(PostRequest.toServiceDto(
                email,
                postRequest.getTitle(),
                postRequest.getContent()
        ));
    }

    @PatchMapping(consumes = "application/json")
    public final String modifyPost(@RequestBody @Valid final PostModifyRequest postModifyRequest, final HttpServletRequest httpServletRequest) {
        final String token = httpServletRequest.getHeader("Authorization");
        final String email = jwtTokenProvider.generateTokenToEmail(token);
        postService.modifyPost(PostModifyRequest.toServiceDto(
                email,
                postModifyRequest.getId(),
                postModifyRequest.getTitle(),
                postModifyRequest.getContent()
        ));
        return "Success";
    }

    @GetMapping(value = "/{id}")
    public final PostResponse findById(@PathVariable("id") final Long id) {
        logger.info("Get Post {}", id);
        PostServiceResponse postServiceResponse = postService.findById(id);
        return PostResponse.newInstance(
                postServiceResponse.getId(),
                postServiceResponse.getTitle(),
                postServiceResponse.getContent()
        );
    }

    @GetMapping(value = "/all")
    public final List<PostResponse> getAll(@RequestParam(value = "order",required = false, defaultValue = "new") final String order) {
        if(!order.equals("new") && !order.equals("like")) {
            throw new IllegalArgumentException("올바른 파라미터 필요");
        }

        return postService.getAllPost(order)
                .stream()
                .map(post -> PostResponse.newInstance(
                        post.getId(),
                        post.getTitle(),
                        post.getContent()
                )).collect(Collectors.toList());
    }

    @GetMapping(value = "/my-post")
    public final List<PostResponse> getMyPosts(@RequestParam(value = "order", required = false, defaultValue = "new") final String order, final HttpServletRequest httpServletRequest) {
        final String token = httpServletRequest.getHeader("Authorization");
        final String email = jwtTokenProvider.generateTokenToEmail(token);
        if(!order.equals("new") && !order.equals("like")) {
            throw new IllegalArgumentException("올바른 파라미터 필요");
        }
        logger.info("회원의 post 불러오기");
        return postService.getMyPosts(order, email)
                .stream()
                .map(post -> PostResponse.newInstance(
                        post.getId(),
                        post.getTitle(),
                        post.getContent()
                )).collect(Collectors.toList());
    }

    @DeleteMapping(value = "/post/{postId}")
    public final String deletePost (@PathVariable("postId") final Long postId, final HttpServletRequest httpServletRequest) {
        final String token = httpServletRequest.getHeader("Authorization");
        final String email = jwtTokenProvider.generateTokenToEmail(token);
        postService.deletePost(DeletePostServiceRequest.newInstance(email, postId));
        return "SUCCESS - POST Delete";
    }
}
