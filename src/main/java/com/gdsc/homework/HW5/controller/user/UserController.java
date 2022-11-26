package com.gdsc.homework.HW5.controller.user;

import com.gdsc.homework.HW5.controller.user.dto.request.UserRequest;
import com.gdsc.homework.HW5.controller.user.dto.response.UserResponse;
import com.gdsc.homework.HW5.service.user.UserService;
import com.gdsc.homework.HW5.service.user.dto.response.UserServiceResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    @PostMapping(value = "/signUp", consumes = "application/json")
    public final UserResponse signUp(@RequestBody UserRequest userRequest) {
        UserServiceResponse userServiceResponse = userService.enroll(UserRequest.toServiceDto(
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getPassword()
        ));
        logger.info("SignUp User");
        return UserResponse.newInstance(
                userServiceResponse.getId(),
                userServiceResponse.getName(),
                userServiceResponse.getEmail(),
                userServiceResponse.getPassword());
    }

    @GetMapping("/user/{id}")
    public final UserResponse searchUser(@PathVariable Long id) {
        logger.info("Search User {}", id);
        UserServiceResponse userServiceResponse = userService.findById(id);

        return UserResponse.newInstance(
                userServiceResponse.getId(),
                userServiceResponse.getName(),
                userServiceResponse.getEmail(),
                userServiceResponse.getPassword()
        );

    }
}
