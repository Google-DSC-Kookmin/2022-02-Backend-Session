package com.gdsc.homework.controller.user;

import com.gdsc.homework.controller.user.dto.request.LoginUserRequest;
import com.gdsc.homework.controller.user.dto.request.UserRequest;
import com.gdsc.homework.controller.user.dto.response.UserResponse;
import com.gdsc.homework.jwt.JwtTokenProvider;
import com.gdsc.homework.service.user.UserService;
import com.gdsc.homework.service.user.dto.response.UserServiceResponse;
import com.gdsc.homework.validAPI.UserValidation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider = JwtTokenProvider.newInstance();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserValidation userValidation;

    @PostMapping(value = "/signUp", consumes = "application/json")
    public final Long signUp(@RequestBody UserRequest userRequest) {
        userValidation.duplicateEmail(userRequest.getEmail());
        userValidation.duplicateNickname(userRequest.getNickname());
        Long userId = userService.enroll(UserRequest.toServiceDto(
                userRequest.getEmail(),
                userRequest.getNickname(),
                userRequest.getPassword()
        ));
        logger.info("enroll user email {}", userRequest.getEmail());
        return userId;
    }

    @GetMapping("/user/{id}")
    public final UserResponse findById(@PathVariable Long id) {
        logger.info("Search User {}", id);
        UserServiceResponse userServiceResponse = userService.findById(id);
        return UserResponse.newInstance(
                userServiceResponse.getId(),
                userServiceResponse.getEmail(),
                userServiceResponse.getNickname()
        );
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public final String login(@RequestBody LoginUserRequest loginUserRequest) {
        userValidation.presentUserEmail(loginUserRequest.getEmail());
        userValidation.isCorrectPassword(loginUserRequest.getEmail(), loginUserRequest.getPassword());
        return jwtTokenProvider.createJwt(loginUserRequest.getEmail());
    }
}

