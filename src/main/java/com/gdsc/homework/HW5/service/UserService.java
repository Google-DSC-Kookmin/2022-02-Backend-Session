package com.gdsc.homework.HW5.service;

import com.gdsc.homework.HW5.domain.User;
import com.gdsc.homework.HW5.repository.UserRepository;
import com.gdsc.homework.HW5.service.dto.request.UserServiceRequest;
import com.gdsc.homework.HW5.service.dto.response.UserServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public final UserServiceResponse enroll(UserServiceRequest userServiceRequest) {
        validateDuplicateEmail(userServiceRequest.getEmail());
        User saveUser = userRepository.save(User.newInstance(
                userServiceRequest.getName(),
                userServiceRequest.getEmail(),
                userServiceRequest.getPassword()
        ));
        return UserServiceResponse.of(saveUser.getId(), saveUser.getName(), saveUser.getEmail(), saveUser.getPassword());
    }

    public final UserServiceResponse findById(Long id) {
        Optional<User> optional =  userRepository.findById(id);
        validatePresentUser(optional);
        User user = optional.get();
        return UserServiceResponse.of(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );

    }

    private void validateDuplicateEmail(String email) {
        userRepository.findByEmail(email)
                .ifPresent(u-> {
                    throw new IllegalStateException("이미 존재하는 이메일입니다.");
                });
    }

    private void validatePresentUser(Optional<User> optional) {
        if(optional.isEmpty()) {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }
    }


}
