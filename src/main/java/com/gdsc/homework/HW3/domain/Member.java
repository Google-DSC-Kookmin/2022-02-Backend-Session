package com.gdsc.homework.HW3.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
* @Entity: 테이블과 링크될 클래스
* 기본값으로 카멜케이스 이름을 언더 스코어 네이밍으로 테이블 이름을 매칭
* @Getter: Lombok, 접근자 자동 생성
* */
//@Entity
@Getter
@NoArgsConstructor
public class Member {

    /*
    * @Id: PK 필드
    * @GeneratedValue(stragety = GenerationType.IDENTITY)
    * PK 생성 규칙: GenerationType.IDENTITY옵션을 추가해야만 auto_increament 사용 가능)
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String userId;
    private String description;

    private Member(final String name, final String userId, final String description) {
        this.name = name;
        this.userId = userId;
        this.description = description;
    }

    public static Member newInstance(final String name,final String userId, final String description) {
        return new Member(name, userId, description);
    }
}
