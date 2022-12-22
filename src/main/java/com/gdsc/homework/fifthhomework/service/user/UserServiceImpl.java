package com.gdsc.homework.fifthhomework.service.user;

import com.gdsc.homework.fifthhomework.domain.user.User;
import com.gdsc.homework.fifthhomework.domain.user.UserRepository;
import com.gdsc.homework.fifthhomework.dto.user.controller.SignUpDto;
import com.gdsc.homework.fifthhomework.dto.user.service.SignUpServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void SignUp(SignUpDto signUpDto) {

        // validation 구간
        Optional<User> findUser = userRepository.findByEmail(signUpDto.getEmail());
        if(findUser.isPresent()){
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }

        // user 객체 생성
        User newUser = User.newInstance(signUpDto.getEmail(),
                signUpDto.getNickname(),
                signUpDto.getPassword());

        // 레포지토리에 등록
        userRepository.save(newUser);
    }
}
