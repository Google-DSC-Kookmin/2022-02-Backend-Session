package com.gdsc.homework.fifthhomework.domain.post;


import com.gdsc.homework.fifthhomework.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;


    private Post(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public static Post newInstance(final String title, final String description, final User user){
        return new Post(title,description,user);
    }


}
