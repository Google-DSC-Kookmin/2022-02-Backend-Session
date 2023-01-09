package com.gdsc.homework.controller.article.dto.request;

import com.gdsc.homework.service.article.dto.request.ArticleDto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    public ArticleDto toServiceDto() {
        return ArticleDto.of(title, content);
    }
}
