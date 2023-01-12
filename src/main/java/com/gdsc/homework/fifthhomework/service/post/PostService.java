package com.gdsc.homework.fifthhomework.service.post;

import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.dto.post.request.PostPostDto;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByIdDescDto;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByLikesDto;

import java.util.List;

public interface PostService {

    List<PostsOrderByIdDescDto> getPostsMain();

    List<PostsOrderByLikesDto> getPostsOrderByLike();

    void postPost(PostPostDto postPostDto);

    void postUpdate(PostPostDto postPostDto,Long postId);

    void postDelete(Long postId);
}
