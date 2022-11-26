package com.gdsc.homework.HW5.controller;

import com.gdsc.homework.HW5.controller.dto.request.UserRequest;
import com.gdsc.homework.HW5.controller.dto.response.UserResponse;
import com.gdsc.homework.HW5.service.UserService;
import com.gdsc.homework.HW5.service.dto.response.UserServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/signUp", consumes = "application/json")
    public final UserResponse signUp(@RequestBody UserRequest userRequest) {
        UserServiceResponse userServiceResponse = userService.enroll(UserRequest.toServiceDto(
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getPassword()
        ));
        return UserResponse.newInstance(
                userServiceResponse.getId(),
                userServiceResponse.getName(),
                userServiceResponse.getEmail(),
                userServiceResponse.getPassword());
    }
}
