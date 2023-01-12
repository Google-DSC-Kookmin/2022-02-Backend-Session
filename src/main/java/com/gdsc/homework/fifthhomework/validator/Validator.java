package com.gdsc.homework.fifthhomework.validator;

import com.gdsc.homework.fifthhomework.domain.user.User;
import com.gdsc.homework.fifthhomework.domain.user.UserRepository;
import com.gdsc.homework.fifthhomework.dto.user.request.SignInDto;
import com.gdsc.homework.fifthhomework.dto.user.request.SignUpDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class Validator {

    private final UserRepository userRepository;

    public void validateSignUp(SignUpDto signUpDto){
        // validation 구간
        Optional<User> findUser = userRepository.findByEmail(signUpDto.getEmail());
        if(findUser.isPresent()){
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
        if(!signUpDto.getEmail().equals("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$")){
            throw new IllegalArgumentException("이메일 형식을 지켜주세요");
        }
        if(!signUpDto.getPassword().equals("^[A-Za-z0-9]{4,8}$")){
            throw new IllegalArgumentException("비밀번호는 숫자, 문자 포함의 4~8자리 이내로 해주세요");
        }
    }

    public void validateSignIn(SignInDto signInDto){
        if(signInDto.getEmail().equals("")){
            throw new IllegalArgumentException("이메일을 입력해주세요");
        }
        if(signInDto.getPassword().equals("")){
            throw new IllegalArgumentException("비밀번호를 입력해주세요");
        }
        Optional<User> byEmail = userRepository.findByEmail(signInDto.getEmail());
        if(byEmail.isEmpty()){
            throw new IllegalArgumentException("회원가입을 해주세요");
        }
        Optional<User> byPassword = userRepository.findByPassword(signInDto.getPassword());
        if(byPassword.isEmpty()){
            throw new IllegalArgumentException("회원가입을 해주세요");
        }
    }
}
