package com.gdsc.homework.firstAssignment.service.post;

import com.gdsc.homework.firstAssignment.controller.post.dto.PostModifyReqDto;
import com.gdsc.homework.firstAssignment.controller.post.dto.PostWriteReqDto;
import com.gdsc.homework.firstAssignment.domain.post.Post;
import com.gdsc.homework.firstAssignment.domain.post.PostRepository;
import com.gdsc.homework.firstAssignment.domain.user.User;
import com.gdsc.homework.firstAssignment.domain.user.UserRepository;
import com.gdsc.homework.firstAssignment.service.post.dto.PostListResDto;
import com.gdsc.homework.firstAssignment.service.post.dto.PostResDto;
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

    public PostResDto writePost(final Long userId, PostWriteReqDto postWriteReqDto) {
        String title = postWriteReqDto.getTitle();
        String content = postWriteReqDto.getContent();
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 user id 입니다."));
        Post post = Post.newInstance(title, content, user);
        postRepository.save(post);
        return PostResDto.of(post);
    }

    public PostResDto modifyPost(final Long postId, PostModifyReqDto postModifyReqDto) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 post id 입니다."));
        String title = postModifyReqDto.getTitle();
        String content = postModifyReqDto.getContent();
        post.setTitle(title);
        post.setContent(content);
        postRepository.save(post);
        return PostResDto.of(post);
    }

    public void deletePost(final Long postId) {
        postRepository.deleteById(postId);
    }

    public PostListResDto getRecentPost() {
        List<Post> postList = postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        Long postCnt = postRepository.count();
        List<PostResDto> postResDtoList = postList.stream()
                .map(PostResDto::of)
                .collect(Collectors.toList());
        return PostListResDto.of(postResDtoList, postCnt);
    }

    public PostListResDto getMostLikedPost() {
        List<Post> postList = postRepository.findAll(Sort.by(Sort.Direction.DESC, "likeCount"));
        Long postCnt = postRepository.count();
        List<PostResDto> postResDtoList = postList.stream()
                .map(PostResDto::of)
                .collect(Collectors.toList());
        return PostListResDto.of(postResDtoList, postCnt);
    }
}
