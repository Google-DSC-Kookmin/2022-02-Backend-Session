package com.gdsc.homework.controller;

import com.gdsc.homework.controller.dto.ResponseDTO;
import com.gdsc.homework.controller.dto.request.ArticleRequest;
import com.gdsc.homework.domain.User;
import com.gdsc.homework.service.ArticleService;
import com.gdsc.homework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    @PostMapping("/save")
    public String save (@RequestBody ArticleRequest articleRequest){
        try {
            articleService.save(articleRequest.toServiceDto());
            return "ok";
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return responseDTO.getError();
        }
    }
}
