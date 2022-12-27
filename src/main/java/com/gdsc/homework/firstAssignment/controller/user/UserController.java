package com.gdsc.homework.firstAssignment.controller.user;

import com.gdsc.homework.firstAssignment.controller.user.dto.UserRegisterReqDto;
import com.gdsc.homework.firstAssignment.service.user.UserService;
import com.gdsc.homework.firstAssignment.service.user.dto.UserRegisterResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/register")
    public UserRegisterResDto registerUser(@RequestBody UserRegisterReqDto userRegisterReqDto) {
        return userService.registerUser(userRegisterReqDto);
    }
}
