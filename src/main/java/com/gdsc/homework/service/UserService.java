package com.gdsc.homework.service;

import com.gdsc.homework.domain.User;
import com.gdsc.homework.repository.UserRepository;
import com.gdsc.homework.service.dto.request.UserDTO;
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
        User requestUser = User.newInstanc(userDTO.getNickname(), userDTO.getEmail(), userDTO.getPassword());
        userRepository.save(requestUser);
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

}
