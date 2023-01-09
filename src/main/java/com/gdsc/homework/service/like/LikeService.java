package com.gdsc.homework.service.like;

import com.gdsc.homework.config.security.JwtService;
import com.gdsc.homework.domain.article.Article;
import com.gdsc.homework.domain.article.ArticleRepository;
import com.gdsc.homework.domain.like.Like;
import com.gdsc.homework.domain.like.LikeRepository;
import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final JwtService jwtService;
    @Transactional
    public String postLike(Long articleId) {
        Long userId = jwtService.getUserId();
        User foundUser = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        Article foundArticle = articleRepository.findArticleByArticleId(articleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        if (!likeRepository.existsLikeByUserIdAndArticleId(foundUser, foundArticle)) {
            Like newLike = Like.newInstance(foundUser, foundArticle);
            likeRepository.save(newLike);
            foundArticle.addLikeCount();
            articleRepository.save(foundArticle);
            return "좋아요 생성 후 성공";
        }
        Like foundLikeInfo = likeRepository.findLikeByUserIdAndArticleId(foundUser, foundArticle)
                .orElseThrow(() -> new IllegalArgumentException("좋아요 정보를 불러오는데 실패하였습니다."));
        if (!foundLikeInfo.isLiked()) {
            foundLikeInfo.postLike();
            foundArticle.addLikeCount();
            articleRepository.save(foundArticle);
        }
        return "좋아요 성공";
    }

    @Transactional
    public String deleteLike(Long articleId) {
        Long userId = jwtService.getUserId();
        User foundUser = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        Article foundArticle = articleRepository.findArticleByArticleId(articleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        Like foundLikeInfo = likeRepository.findLikeByUserIdAndArticleId(foundUser, foundArticle)
                .orElseThrow(() -> new IllegalArgumentException("좋아요 정보를 불러오는데 실패하였습니다."));
        if (foundLikeInfo.isLiked()){
            foundLikeInfo.deleteLike();
            foundArticle.subLikeCount();
            articleRepository.save(foundArticle);
        }
        return "좋아요 삭제 성공";
    }
}
