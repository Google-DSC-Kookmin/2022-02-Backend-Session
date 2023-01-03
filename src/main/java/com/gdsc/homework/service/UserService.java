package com.gdsc.homework.service;

import com.gdsc.homework.domain.user.Users;
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
        userRepository.save(Users.newInstance(userDTO.getNickname(), userDTO.getEmail(), userDTO.getPassword()));
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
    public Users getUser(Long userId){
        Users foundUsers = userRepository.findByUserID(userId)
                .orElseThrow(()-> new IllegalArgumentException("없는 유저입니다."));
        return foundUsers;
    }
    public UserResponse getUserDto(Long userId){
        Users foundUsers = userRepository.findByUserID(userId)
                .orElseThrow(()-> new IllegalArgumentException("없는 유저입니다."));
        return UserResponse.of(foundUsers.getUserID(), foundUsers.getNickName(), foundUsers.getEmail());
    }

    public UserResponse signin(UserDTO userDTO) {
        Users signinUsers = userRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword())
                .orElseThrow(() -> new IllegalArgumentException("로그인 정보가 틀렸습니다"));
        return UserResponse.of(signinUsers.getUserID(), signinUsers.getNickName(), signinUsers.getEmail());
    }

    public UserResponse update(UserDTO userDTO) {
        Users getUsers = getUser(userDTO.getUserId());
        validateDuplicateUser(userDTO);
        getUsers.updateUser(userDTO.getNickname(), userDTO.getEmail());
        Users savedUsers = userRepository.save(getUsers);
        return UserResponse.of(savedUsers.getUserID(), savedUsers.getNickName(), savedUsers.getEmail());
    }
}
