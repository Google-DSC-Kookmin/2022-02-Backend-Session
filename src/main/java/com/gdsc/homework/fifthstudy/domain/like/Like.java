package com.gdsc.homework.fifthstudy.domain.like;

import com.gdsc.homework.fifthstudy.domain.article.Article;
import com.gdsc.homework.fifthstudy.domain.comment.Comment;
import com.gdsc.homework.fifthstudy.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "LIKES")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

//    @Column
//    private String status;

    private Like(User user, Article article) {
        this.user = user;
        this.article = article;
    }
    public static Like newInstance(final User user, final Article article){
        return new Like(user, article);
    }
}
