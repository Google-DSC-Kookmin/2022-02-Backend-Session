package com.gdsc.homework.config;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    SUCCESS(true, 1000, "요청에 성공하였습니다.");
    private final boolean isSuccess;
    private final int responseCode;
    private final String message;
    private BaseResponseStatus(boolean isSuccess, int responseCode, String message) {
        this.isSuccess = isSuccess;
        this.responseCode = responseCode;
        this.message = message;
    }
}
