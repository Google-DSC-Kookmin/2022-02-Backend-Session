package com.gdsc.homework.domain.article;

import com.gdsc.homework.domain.base.BaseStatus;
import com.gdsc.homework.domain.base.BaseTimeEntity;
import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.service.comment.dto.response.CommentResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@DynamicUpdate
@Table(name = "articles")
@SQLDelete(sql = "UPDATE articles SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Article extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    @Column
    private String title;
    @Column(length = 1000)
    private String content;
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;
    @Column(name = "like_count")
    private Long likeCount;
    public Article(String title, String content, User userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.isDeleted = Boolean.FALSE;
        this.likeCount = 0L;

    }

    public static Article newInstace(final String title, final String content, final User userId) {
        return new Article(title, content, userId);
    }

    public void updateContent(String title, String content) {
        if(title != null && !title.isEmpty()) this.title = title;
        if(content != null && !content.isEmpty()) this.content = content;
    }

    public void deleteArticle() {
        this.isDeleted = Boolean.TRUE;
    }

    public boolean checkDeleted(){
        if (this.isDeleted == Boolean.TRUE) return true;
        return false;
    }

    public void addLikeCount() {
        this.likeCount++;
    }
    public void subLikeCount() {
        this.likeCount--;
    }
}
