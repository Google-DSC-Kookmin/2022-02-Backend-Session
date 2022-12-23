package com.gdsc.homework.fifthhomework.service.post;

import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByIdDescDto;
import com.gdsc.homework.fifthhomework.dto.post.response.PostsOrderByLikesDto;

import java.util.List;

public interface PostService {

    List<PostsOrderByIdDescDto> getPostsMain();

    List<PostsOrderByLikesDto> getPostsOrderByLike();
}
