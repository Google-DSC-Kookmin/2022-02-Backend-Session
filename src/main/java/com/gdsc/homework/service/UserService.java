package com.gdsc.homework.service;

import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import com.gdsc.homework.service.dto.request.UserDTO;
import com.gdsc.homework.service.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void signUp(UserDTO userDTO) {
        validateDuplicateUser(userDTO);
        userRepository.save(User.newInstance(userDTO.getNickname(), userDTO.getEmail(), userDTO.getPassword()));
    }
    private void validateDuplicateUser(UserDTO userDTO){
        userRepository.findByEmail(userDTO.getEmail())
                .ifPresent(m ->{
                    log.error("이메일 중복, email : {}",userDTO.getEmail());
                throw new IllegalArgumentException("UserEmail already exists");
        });
        userRepository.findByNickName(userDTO.getNickname()).ifPresent(m->{
        log.error("닉네임 중복, nickname:{}",userDTO.getNickname());
            throw new IllegalArgumentException("UserNickname already exists");
        });
    }
    public User getUser(Long userId){
        User foundUser = userRepository.findByUserID(userId)
                .orElseThrow(()-> new IllegalArgumentException("없는 유저입니다."));
        return foundUser;
    }
    public UserResponse getUserDto(Long userId){
        User foundUser = userRepository.findByUserID(userId)
                .orElseThrow(()-> new IllegalArgumentException("없는 유저입니다."));
        return UserResponse.of(foundUser.getUserID(),foundUser.getNickName(),foundUser.getEmail());
    }

    public UserResponse signin(UserDTO userDTO) {
        User signinUser = userRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword())
                .orElseThrow(() -> new IllegalArgumentException("로그인 정보가 틀렸습니다"));
        return UserResponse.of(signinUser.getUserID(), signinUser.getNickName(), signinUser.getEmail());
    }

    public UserResponse update(UserDTO userDTO) {
        User getUser = getUser(userDTO.getUserId());
        validateDuplicateUser(userDTO);
        getUser.updateUser(userDTO.getNickname(), userDTO.getEmail());
        User savedUser = userRepository.save(getUser);
        return UserResponse.of(savedUser.getUserID(), savedUser.getNickName(), savedUser.getEmail());
    }
}
