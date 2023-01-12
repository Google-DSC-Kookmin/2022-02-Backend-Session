package com.gdsc.homework.controller;

import com.gdsc.homework.auth.Auth;
import com.gdsc.homework.auth.UserId;
import com.gdsc.homework.controller.dto.request.SignUpRequestDto;
import com.gdsc.homework.controller.dto.response.LoginResponse;
import com.gdsc.homework.jwt.JwtService;
import com.gdsc.homework.service.UserService;
import com.gdsc.homework.service.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final JwtService jwtService;
    private final UserService userService;

    @PostMapping("/v1/signup")
    public LoginResponse signUp(@Valid @RequestBody final SignUpRequestDto request) {
        final Long userId = userService.signUp(request.toServiceDto());
        final String token = jwtService.issuedToken(String.valueOf(userId), "USER", 60 * 60 * 24 * 30L);
        return LoginResponse.of(token);
    }

    @GetMapping("/v1/users")
    @Auth
    public UserResponse getUser(@UserId final Long userId){
        return userService.getUser(userId);
    }
}
