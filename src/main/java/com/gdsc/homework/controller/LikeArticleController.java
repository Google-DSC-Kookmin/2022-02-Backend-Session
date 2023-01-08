package com.gdsc.homework.controller;

import com.gdsc.homework.controller.dto.response.ResponseDTO;
import com.gdsc.homework.controller.dto.request.LikeArticleReqeust;
import com.gdsc.homework.service.LikeArticleService;
import com.gdsc.homework.service.dto.response.LikeArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeArticleController {
    private final LikeArticleService likeArticleService;
    @PostMapping()
    public ResponseEntity<?> like(@Valid @RequestBody LikeArticleReqeust likeArticleReqeust){
        try {
            LikeArticleResponse getLikeArticle = likeArticleService.like(likeArticleReqeust.toServiceDto());
            return ResponseEntity.ok(getLikeArticle);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

}
