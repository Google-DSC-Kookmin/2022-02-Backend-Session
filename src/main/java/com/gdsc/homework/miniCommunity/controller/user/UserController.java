package com.gdsc.homework.miniCommunity.controller.user;

import com.gdsc.homework.miniCommunity.controller.user.dto.request.UserRequest;
import com.gdsc.homework.miniCommunity.service.user.UserService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value="/sign-up", consumes="application/json")
    public String signUp(@RequestBody UserRequest userRequest) {
        userService.signUp(userRequest);
        return "signUp";
    }

    @PostMapping(value="/sign-in", consumes="application/json")
    public String signIn(@RequestBody UserRequest userRequest) {
        userService.signIn(userRequest);
        return "signIn";
    }
}
