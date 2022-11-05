package com.gdsc.homework.thirdstudy.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String name;

    @Column
    private String description;

    private Member(final String name,final String description) {
        this.name = name;
        this.description = description;
    }

    public static Member newInstance(final String name,final String description){
        return new Member(name,description);
    }
}
