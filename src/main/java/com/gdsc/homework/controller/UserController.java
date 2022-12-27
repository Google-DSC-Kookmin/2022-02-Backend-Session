package com.gdsc.homework.controller;

import com.gdsc.homework.controller.dto.ResponseDTO;
import com.gdsc.homework.controller.dto.request.UserRequest;
import com.gdsc.homework.controller.dto.response.UserDTO;
import com.gdsc.homework.security.TokenProvider;
import com.gdsc.homework.service.UserService;
import com.gdsc.homework.service.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService ;
    private final TokenProvider tokenProvider;


    @PostMapping("/signup")
    public String signUp(@Valid @RequestBody UserRequest userRequest){
        try {
            userService.signUp(userRequest.toServiceDto());
            return "signup";
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return responseDTO.getError();
        }
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserRequest userRequest){
        try {
            UserResponse userResponse = userService.signin(userRequest.toServiceDto());
            final String token = tokenProvider.createToken(userResponse);
            UserDTO responseDTO = UserDTO.of(token, userResponse.getEmail(), userResponse.getNickName(), userResponse.getUserId());
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }

    }
}
