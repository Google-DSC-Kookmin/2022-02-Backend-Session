package com.gdsc.homework.service;

import com.gdsc.homework.domain.Article;
import com.gdsc.homework.domain.User;
import com.gdsc.homework.repository.ArticleRepository;
import com.gdsc.homework.repository.UserRepository;
import com.gdsc.homework.service.dto.request.ArticleDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserService userService;
    public void save(ArticleDTO articleDTO) {
        User foundUser = userService.getUser(articleDTO.getUserId());
        articleRepository.save(Article.newInstance(articleDTO.getTitle(), articleDTO.getContent(), foundUser));
    }
}
