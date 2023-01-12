package com.gdsc.homework.fifthhomework.service.like;

import com.gdsc.homework.fifthhomework.dto.like.response.LikeResponseDto;

public interface LikeService {

    LikeResponseDto getLike(Long postId, String email);

    void postLike(Long postId, String email);


}
