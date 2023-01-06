package com.gdsc.homework.controller.user;

import com.gdsc.homework.controller.user.dto.request.ChangeUserInfoRequest;
import com.gdsc.homework.controller.user.dto.request.LoginUserRequest;
import com.gdsc.homework.controller.user.dto.request.UserRequest;
import com.gdsc.homework.controller.user.dto.response.UserResponse;
import com.gdsc.homework.auth.jwt.JwtTokenProvider;
import com.gdsc.homework.service.user.UserService;
import com.gdsc.homework.service.user.dto.response.UserServiceResponse;
import com.gdsc.homework.validAPI.UserValidation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value="/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider = JwtTokenProvider.newInstance();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserValidation userValidation;

    @PostMapping(value = "/signUp", consumes = "application/json")
    public final Long signUp(@RequestBody @Valid final UserRequest userRequest) {
        Long userId = userService.enroll(UserRequest.toServiceDto(
                userRequest.getEmail(),
                userRequest.getNickname(),
                userRequest.getPassword()
        ));
        logger.info("enroll user email {}", userRequest.getEmail());
        return userId;
    }

    @GetMapping("/{id}")
    public final UserResponse findById(@PathVariable @Valid final Long id) {
        logger.info("Search User {}", id);
        UserServiceResponse userServiceResponse = userService.findById(id);
        return UserResponse.newInstance(
                userServiceResponse.getId(),
                userServiceResponse.getEmail(),
                userServiceResponse.getNickname()
        );
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public final String login(@RequestBody @Valid final LoginUserRequest loginUserRequest) {
        userValidation.presentUserEmail(loginUserRequest.getEmail());
        userValidation.isCorrectPassword(loginUserRequest.getEmail(), loginUserRequest.getPassword());
        return jwtTokenProvider.createJwt(loginUserRequest.getEmail());
    }
    @PatchMapping(value = "/edit", consumes = "application/json")
    public final String modifyNickName(@RequestBody @Valid final ChangeUserInfoRequest changeUserInfoRequest, final HttpServletRequest httpServletRequest) {
        final String token = httpServletRequest.getHeader("Authorization");
        final String email = jwtTokenProvider.generateTokenToEmail(token);
        logger.info("User Edit info");
        userService.editInfo(ChangeUserInfoRequest.toServiceDto(
                email,
                changeUserInfoRequest.getEmail(),
                changeUserInfoRequest.getNickname()
        ));
        return "SUCCESS MODIFY NICKNAME";
    }
}

