package com.gdsc.homework.fifthhomework.dto.post.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
public class PostsOrderByLikesDto {

    private Long id;
    private String title;
    private String description;
}
