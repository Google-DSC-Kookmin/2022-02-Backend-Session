package com.gdsc.homework.firstAssignment.service.user;

import com.gdsc.homework.firstAssignment.controller.user.dto.UserRegisterReqDto;
import com.gdsc.homework.firstAssignment.domain.user.User;
import com.gdsc.homework.firstAssignment.domain.user.UserRepository;
import com.gdsc.homework.firstAssignment.service.user.dto.UserRegisterResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserRegisterResDto registerUser(UserRegisterReqDto userRegisterReqDto) {
        String email = userRegisterReqDto.getEmail();
        String nickname = userRegisterReqDto.getNickname();
        User user = User.newInstance(email, nickname);
        userRepository.save(user);
        return UserRegisterResDto.of(user);
    }
}
