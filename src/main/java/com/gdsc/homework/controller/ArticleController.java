package com.gdsc.homework.controller;

import com.gdsc.homework.controller.dto.ResponseDTO;
import com.gdsc.homework.controller.dto.request.ArticleRequest;
import com.gdsc.homework.controller.dto.response.ArticleDTO;
import com.gdsc.homework.service.ArticleService;
import com.gdsc.homework.service.dto.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    @PostMapping("/save")
    public ResponseEntity<?> save (@RequestBody ArticleRequest articleRequest){
        try {
            articleService.save(articleRequest.toServiceDto());
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ArticleRequest articleRequest){
        try {
            ArticleResponse updatedArticle=articleService.update(articleRequest.toUpdateServiceDTO());
            ArticleDTO responseDTO = ArticleDTO.of(updatedArticle.getArticleId(), updatedArticle.getTitle(), updatedArticle.getContent(), updatedArticle.getUserId());
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
