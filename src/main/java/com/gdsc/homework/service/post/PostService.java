package com.gdsc.homework.service.post;

import com.gdsc.homework.domain.post.Post;
import com.gdsc.homework.domain.post.PostRepository;
import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import com.gdsc.homework.service.post.dto.request.PostServiceModifyRequest;
import com.gdsc.homework.service.post.dto.request.PostServiceRequest;
import com.gdsc.homework.service.post.dto.response.PostServiceResponse;
import com.gdsc.homework.validAPI.PostValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostValidation postValidation;

    public final Long uploadPost(PostServiceRequest postServiceRequest) {
        Optional<User> auther = userRepository.findByEmail(postServiceRequest.getEmail());
        Post savePost = postRepository.save(Post.newInstance(
                postServiceRequest.getTitle(),
                postServiceRequest.getContent(),
                auther.get()
        ));
        return savePost.getId();
    }

    public final void modifyPost(PostServiceModifyRequest postServiceModifyRequest) {
        Optional <Post> NullablePost = postRepository.findById(postServiceModifyRequest.getId());
        postValidation.userHasPost(postServiceModifyRequest.getEmail(), NullablePost);

        Post post = NullablePost.get();
        post.setTitle(postServiceModifyRequest.getTitle());
        post.setContent(postServiceModifyRequest.getContent());
        postRepository.save(post);
    }

    public final void deletePost() {

    }

    public final PostServiceResponse findById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return PostServiceResponse.of(
                post.get().getId(),
                post.get().getTitle(),
                post.get().getContent()
        );
    }
}
