package com.gdsc.homework.fifthhomework.controller;

import com.gdsc.homework.fifthhomework.dto.user.controller.SignUpDto;
import com.gdsc.homework.fifthhomework.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/sginup")
    public String signUp(@RequestBody SignUpDto signUpDto){
        userService.SignUp(signUpDto);
        return "ok";
    }


}
