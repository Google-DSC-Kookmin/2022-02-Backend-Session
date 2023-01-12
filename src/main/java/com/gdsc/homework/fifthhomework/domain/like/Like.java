package com.gdsc.homework.fifthhomework.domain.like;

import com.gdsc.homework.fifthhomework.domain.post.Post;
import com.gdsc.homework.fifthhomework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Boolean isLike;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "USER _ID")
    private User user;



    private Like(User user, Post post) {
        // isLike는 처음에 생성할 때는 true로 반환
        // 이후 값이 있는지를 체크한 후 update 통해 해결한다.
        this.user = user;
        this.post = post;
        this.isLike = true;
    }

    public static Like newInstance(final User user, final Post post){
        return new Like(user,post);
    }

    public void update() {
        this.isLike = !this.isLike;
    }
}
