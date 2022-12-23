package com.gdsc.homework.controller.dto;

import lombok.*;

import java.util.List;
@Builder
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDTO {
    private String error;
    private List<?> data;
}
