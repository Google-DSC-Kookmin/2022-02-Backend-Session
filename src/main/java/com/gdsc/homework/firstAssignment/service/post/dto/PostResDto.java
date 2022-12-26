package com.gdsc.homework.firstAssignment.service.post.dto;

import com.gdsc.homework.firstAssignment.domain.post.Post;
import lombok.Getter;

@Getter
public class PostResDto {
    private String title;
    private String content;
    private String authorNickname;
    private int likeCount;

    public static PostResDto of(Post post) {
        return new PostResDto(post);
    }

    private PostResDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.authorNickname = post.getAuthor().getNickname();
        this.likeCount = post.getLikeCount();
    }
}
