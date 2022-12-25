package com.gdsc.homework.controller.dto.request;

import com.gdsc.homework.service.dto.request.LikeArticleDTO;
import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LikeArticleReqeust {
    @NotNull
    private Long userId;
    @NotNull
    private Long articleId;
    public LikeArticleDTO toServiceDto(){
        return LikeArticleDTO.of(articleId, userId);
    }
}