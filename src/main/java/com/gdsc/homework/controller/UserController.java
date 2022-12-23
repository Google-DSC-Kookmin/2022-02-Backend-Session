package com.gdsc.homework.controller;

import com.gdsc.homework.controller.dto.ResponseDTO;
import com.gdsc.homework.controller.dto.request.UserRequest;
import com.gdsc.homework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.catalog.Catalog;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService ;


    @PostMapping("/signup")
    public String signUp(@RequestBody UserRequest userRequest){
        try {
            userService.signUp(userRequest.toServiceDto());
            return "signup";
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return responseDTO.getError();
        }
    }
}
