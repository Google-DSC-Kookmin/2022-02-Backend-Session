package com.gdsc.homework.controller.user;

import com.gdsc.homework.config.BaseResponse;
import com.gdsc.homework.controller.user.dto.request.UserRequest;
import com.gdsc.homework.service.user.UserService;
import com.gdsc.homework.service.user.dto.response.UserDetailResponse;
import com.gdsc.homework.service.user.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final UserService userService;

    @PostMapping(value = "/join")
    public BaseResponse<String> signUp(@Valid @RequestBody final UserRequest dto) {
        log.info("UserRequest: email = {}, nickname = {}", dto.getEmail(), dto.getNickname());
        return new BaseResponse<>(userService.signUp(dto.toServiceDto()));
    }

    @PostMapping(value = "/login")
    public BaseResponse<UserResponse> logIn(@Valid @RequestBody final UserRequest dto) {
        return new BaseResponse<>(userService.logIn(dto.toServiceDto()));
    }

    @GetMapping(value = "")
    public BaseResponse<UserDetailResponse> getUserInfo() {
        return new BaseResponse<>(userService.getUserInfo());
    }

    @PutMapping(value = "")
    public BaseResponse<UserDetailResponse> modifyUserInfo(@Valid @RequestBody final UserRequest userRequestDto) {
        return new BaseResponse<>(userService.updateUserInfo(userRequestDto.toServiceDto()));
    }
}
