package com.gdsc.homework.fifthhomework.controller;

import com.gdsc.homework.fifthhomework.dto.user.request.SignInDto;
import com.gdsc.homework.fifthhomework.dto.user.request.SignUpDto;
import com.gdsc.homework.fifthhomework.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/user/signup")
    public String signUp(@RequestBody SignUpDto signUpDto){
        userService.SignUp(signUpDto);
        return "ok";
    }

    // 로그인 - 세션 발급 관련해서 어려움을 겪음
    @PostMapping("/user/signin")
    public void signIn(@RequestBody SignInDto signInDto, HttpServletResponse httpServletResponse){
        userService.SignIn(signInDto,httpServletResponse);
    }


}
