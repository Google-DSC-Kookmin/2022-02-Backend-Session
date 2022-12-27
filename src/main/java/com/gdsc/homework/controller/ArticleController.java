package com.gdsc.homework.controller;

import com.gdsc.homework.controller.dto.ResponseDTO;
import com.gdsc.homework.controller.dto.request.ArticleRequest;
import com.gdsc.homework.controller.dto.response.ArticleDTO;
import com.gdsc.homework.controller.dto.response.MypageDTO;
import com.gdsc.homework.service.ArticleService;
import com.gdsc.homework.service.UserService;
import com.gdsc.homework.service.dto.response.ArticleResponse;
import com.gdsc.homework.service.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final UserService userService;
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
    @DeleteMapping("/{articleId}")
    public String delete(@PathVariable Long articleId){
        try {
            articleService.delete(articleId);
            return "delete";
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return responseDTO.getError();
        }
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> findByUserId(@PathVariable Long userId){
        try {
            List<ArticleResponse> myArticles = articleService.findByUserId(userId);
            UserResponse foundUser = userService.getUserDto(userId);
            MypageDTO mypageDTO = MypageDTO.builder().email(foundUser.getEmail()).nickName(foundUser.getNickName()).userId(foundUser.getUserId()).articles(myArticles).build();
//            ResponseDTO myArticlesReponseDTO = ResponseDTO.builder().error("").data(myArticles).build();
            return ResponseEntity.ok(mypageDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }

    }
    @GetMapping("/moreLike")
    public ResponseEntity<?> moreLike(){
        try {
            List<ArticleResponse> articles = articleService.moreLike();
            ResponseDTO responseDTO = ResponseDTO.builder().error("").data(articles).build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);

        }

    }
    @GetMapping("/recent")
    public ResponseEntity<?> recent(){
        try {
            List<ArticleResponse> articles = articleService.recent();
            ResponseDTO responseDTO = ResponseDTO.builder().error("").data(articles).build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

}
