package com.gdsc.homework.HW5.service;

import com.gdsc.homework.HW5.domain.User;
import com.gdsc.homework.HW5.repository.UserRepository;
import com.gdsc.homework.HW5.service.dto.request.UserServiceRequest;
import com.gdsc.homework.HW5.service.dto.response.UserServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserServiceResponse enroll(UserServiceRequest userServiceRequest) {
        validateDuplicateEmail(userServiceRequest.getEmail());
        User saveUser = userRepository.save(User.newInstance(
                userServiceRequest.getName(),
                userServiceRequest.getEmail(),
                userServiceRequest.getPassword()
        ));
        return UserServiceResponse.of(saveUser.getId(), saveUser.getName(), saveUser.getEmail(), saveUser.getPassword());
    }

    private void validateDuplicateEmail(String email) {
        userRepository.findByEmail(email)
                .ifPresent(u-> {
                    throw new IllegalStateException("이미 존재하는 이메일입니다.");
                });
    }
}
