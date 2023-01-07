package com.gdsc.homework.service.post;

import com.gdsc.homework.domain.post.Posts;
import com.gdsc.homework.domain.post.PostRepository;
import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import com.gdsc.homework.service.post.dto.request.DeletePostServiceRequest;
import com.gdsc.homework.service.post.dto.request.PostServiceRequest;
import com.gdsc.homework.service.post.dto.request.PostServiceModifyRequest;
import com.gdsc.homework.service.post.dto.response.PostServiceResponse;
import com.gdsc.homework.validAPI.PostValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostValidation postValidation;

    public final Long uploadPost(final PostServiceRequest postServiceRequest) {
        final User auther = userRepository.findByEmail(postServiceRequest.getEmail()).orElseThrow(
                ()-> new IllegalArgumentException("유저가 없습니다.")
        );
        return postRepository.save(Posts.newInstance(
                postServiceRequest.getTitle(),
                postServiceRequest.getContent(),
                auther
        )).getId();
    }

    public final void modifyPost(final PostServiceModifyRequest postServiceModifyRequest) {
        Posts posts = postRepository.findById(postServiceModifyRequest.getId()).orElseThrow(
                () -> new IllegalArgumentException("포스트가 존재하지 않습니다."));
        postValidation.userHasPost(postServiceModifyRequest.getEmail(), posts);

        posts.editTitleAndContent(postServiceModifyRequest.getTitle(), postServiceModifyRequest.getContent());
        postRepository.save(posts);
    }

    public final List<PostServiceResponse> getAllPost(final String order) {
        if(order.equals("new")) {
            return findByCreatedAt();
        }
        return findByLike();
    }

    public final List<PostServiceResponse> getMyPosts(final String order, final String email) {
        final User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("유저 없음"));

        if(order.equals("new")) {
            return findByCreatedAt(user);
        }
        return findByLike(user);
    }

    public final void deletePost(final DeletePostServiceRequest deletePostServiceRequest) {
        postValidation.userHasPost(deletePostServiceRequest.getEmail(), deletePostServiceRequest.getPostId());
        postRepository.deleteById(deletePostServiceRequest.getPostId());
    }

    public final PostServiceResponse findById(final Long id) {
        final Posts posts = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 포스트입니다."));
        return PostServiceResponse.of(
                posts.getId(),
                posts.getTitle(),
                posts.getContent()
        );
    }

    private List<PostServiceResponse> findByCreatedAt(final User user) {
        return postRepository.findByAuther(user, Sort.by(Sort.Direction.DESC,"createAt"))
                .stream()
                .map(post -> PostServiceResponse.of(
                        post.getId(),
                        post.getTitle(),
                        post.getContent()
                )).collect(Collectors.toList());
    }
    private List<PostServiceResponse> findByCreatedAt() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC,"createAt"))
                .stream()
                .map(post -> PostServiceResponse.of(
                        post.getId(),
                        post.getTitle(),
                        post.getContent()
                )).collect(Collectors.toList());
    }

    private List<PostServiceResponse> findByLike(final User user) {
        return postRepository.findByAuther(user, Sort.by(Sort.Direction.DESC,"totalPostLikes"))
                .stream()
                .map(post -> PostServiceResponse.of(
                        post.getId(),
                        post.getTitle(),
                        post.getContent()
                )).collect(Collectors.toList());
    }

    private List<PostServiceResponse> findByLike() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC,"totalPostLikes"))
                .stream()
                .map(post -> PostServiceResponse.of(
                        post.getId(),
                        post.getTitle(),
                        post.getContent()
                )).collect(Collectors.toList());
    }
}
