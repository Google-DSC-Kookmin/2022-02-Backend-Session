package com.gdsc.homework.controller.dto.response;

import lombok.*;

import java.util.List;

@Builder
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MypageDTO {
    private Long userId;
    private String email;
    private String nickName;
    List<?> articles;
}
