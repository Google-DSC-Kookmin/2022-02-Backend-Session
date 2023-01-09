package com.gdsc.homework.service.user;

import com.gdsc.homework.config.security.JwtService;
import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import com.gdsc.homework.service.user.dto.request.UserDto;
import com.gdsc.homework.service.user.dto.response.UserDetailResponse;
import com.gdsc.homework.service.user.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Transactional
    public String signUp(UserDto dto){
        validateUserDuplicate(dto);
        userRepository.save(User.newInstance(dto.getEmail(), dto.getNickname())).getUserId();
        return "User SignUp Success.";
    }

    public UserResponse logIn(UserDto dto) {
        User foundUser = userRepository.findUserByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("없는 유저 입니다."));
        String userJwt = jwtService.createJwt(foundUser.getUserId());
        return UserResponse.of(foundUser.getUserId(), userJwt);
    }

    public UserDetailResponse getUserInfo() {
        Long userId = jwtService.getUserId();
        User foundUser = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("없는 유저입니다."));

        return UserDetailResponse.of(foundUser.getUserId(), foundUser.getEmail(), foundUser.getNickname());
    }

    @Transactional
    public UserDetailResponse updateUserInfo(UserDto userRequest) {
        Long userId = jwtService.getUserId();
        validateUserDuplicate(userRequest);

        User foundUser = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("없는 유저입니다."));

        foundUser.updateUserEmail(userRequest.getEmail());
        foundUser.updateUserNickname(userRequest.getNickname());
        return UserDetailResponse.of(foundUser.getUserId(), foundUser.getEmail(), foundUser.getNickname());
    }
    public void validateUserDuplicate(UserDto dto) throws IllegalArgumentException{
        if (userRepository.existsUserByEmail(dto.getEmail()) || userRepository.existsUserByNickname(dto.getNickname())) {
            throw new IllegalArgumentException("중복된 유저 입니다.");
        }
    }


}
