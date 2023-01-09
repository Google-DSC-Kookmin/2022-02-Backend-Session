package com.gdsc.homework.domain.like;

import com.gdsc.homework.domain.article.Article;
import com.gdsc.homework.domain.base.BaseStatus;
import com.gdsc.homework.domain.base.BaseTimeEntity;
import com.gdsc.homework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "likes")
@SQLDelete(sql = "UPDATE likes SET is_liked = false WHERE id = ?")
public class Like extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article articleId;
    @Column(name = "is_liked")
    private boolean isLiked;

//    @Column
//    private String status;

    private Like(final User userId, final Article articleId) {
        this.userId = userId;
        this.articleId = articleId;
        this.isLiked = Boolean.TRUE;
    }
    public static Like newInstance(final User userId, final Article articleId){
        return new Like(userId, articleId);
    }

    public void postLike() {
        this.isLiked = Boolean.TRUE;
    }

    public void deleteLike() {
        this.isLiked = Boolean.FALSE;
    }
}
