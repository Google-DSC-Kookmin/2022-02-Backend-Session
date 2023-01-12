package com.gdsc.homework.fifthhomework.service.user;

import com.gdsc.homework.fifthhomework.dto.user.request.SignInDto;
import com.gdsc.homework.fifthhomework.dto.user.request.SignUpDto;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    void SignUp(SignUpDto signUpDto);

    void SignIn(SignInDto signInDto, HttpServletResponse servletResponse);

}
