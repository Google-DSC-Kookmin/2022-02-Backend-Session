package com.gdsc.homework.hw5;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity( name="User" )
@Getter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "User")
    List<LikeEntity> likes = new ArrayList<LikeEntity>();

    @OneToMany(mappedBy = "User")
    List<CommentEntity> comments = new ArrayList<CommentEntity>();
}
