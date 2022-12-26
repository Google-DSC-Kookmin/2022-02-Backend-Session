package com.gdsc.homework.service.post;

import com.gdsc.homework.domain.post.Post;
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

import java.util.ArrayList;
import java.util.List;
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

    public final List<PostServiceResponse> getAllPost(String order) {

        String orderProperty = null;
        if(order.equals("new")) {
            orderProperty = "id";
        } else if (order.equals("like")) {
            orderProperty = "totalPostLikes";
        }
        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC,orderProperty));
        List<PostServiceResponse> postServiceResponses = new ArrayList<PostServiceResponse>();
        posts.forEach(post -> {postServiceResponses.add(PostServiceResponse.of(
                post.getId(),
                post.getTitle(),
                post.getContent()
            ));
        });

        return postServiceResponses;
    }

    public final List<PostServiceResponse> getMyPosts(String order, String email) {
        String orderProperty = null;
        if(order.equals("new")) {
            orderProperty = "id";
        } else if (order.equals("like")) {
            orderProperty = "totalPostLikes";
        }
        User user = userRepository.findByEmail(email).get();
        List<Post> posts = postRepository.findByAuther(user);
        List<PostServiceResponse> postServiceResponses = new ArrayList<PostServiceResponse>();
        posts.forEach(post -> {postServiceResponses.add(PostServiceResponse.of(
                post.getId(),
                post.getTitle(),
                post.getContent()
            ));
        });

        return postServiceResponses;
    }

    public final void deletePost(DeletePostServiceRequest deletePostServiceRequest) {
        postValidation.userHasPost(deletePostServiceRequest.getEmail(), deletePostServiceRequest.getPostId());
        postRepository.deleteById(deletePostServiceRequest.getPostId());
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
