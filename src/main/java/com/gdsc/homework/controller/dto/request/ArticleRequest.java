package com.gdsc.homework.controller.dto.request;

import com.gdsc.homework.service.dto.request.ArticleDTO;
import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleRequest {
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private Long userId;

    public ArticleDTO toServiceDto(){
        return ArticleDTO.of(title, content, userId);
    }
}
