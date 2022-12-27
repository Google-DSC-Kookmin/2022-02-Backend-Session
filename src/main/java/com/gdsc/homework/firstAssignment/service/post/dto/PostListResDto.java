package com.gdsc.homework.firstAssignment.service.post.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostListResDto {
    private List<PostResDto> postResDtoList;
    private Long postCnt;

    public static PostListResDto of(List<PostResDto> postResDtoList, Long postCnt) {
        return new PostListResDto(postResDtoList, postCnt);
    }

    private PostListResDto(List<PostResDto> postResDtoList, Long postCnt) {
        this.postResDtoList = postResDtoList;
        this.postCnt = postCnt;
    }
}
