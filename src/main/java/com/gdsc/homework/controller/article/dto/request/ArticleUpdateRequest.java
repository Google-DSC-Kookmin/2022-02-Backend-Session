package com.gdsc.homework.controller.article.dto.request;

import com.gdsc.homework.service.article.dto.request.ArticleDto;
import lombok.*;

import javax.validation.constraints.NotBlank;
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleUpdateRequest {
    private String title;
    private String content;
    public ArticleDto toServiceDto() {
        return ArticleDto.of(title, content);
    }
}
